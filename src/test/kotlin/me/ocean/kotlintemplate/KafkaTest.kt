package me.ocean.kotlintemplate

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils
import org.springframework.stereotype.Component
import org.springframework.test.context.ActiveProfiles


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test-kafka")
@EmbeddedKafka(
    partitions = 1,
    brokerProperties = ["listeners=PLAINTEXT://localhost:32789", "port=32789"],
)
class KafkaTest {
    @Autowired
    lateinit var embeddedKafkaBroker: EmbeddedKafkaBroker

    private fun configureConsumer(): Consumer<String, String>? {
        val consumerProps: MutableMap<String, Any> =
            KafkaTestUtils.consumerProps("test-group", "true", embeddedKafkaBroker)
        consumerProps[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
        consumerProps[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
        consumerProps[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
        val consumer: Consumer<String, String> = DefaultKafkaConsumerFactory<String, String>(consumerProps)
            .createConsumer()
        consumer.subscribe(listOf("fn-invoice.invoice-confirmed"))
        return consumer
    }

    @Test
    fun test(){
        val producer = configureProducer()

        val mapper = jacksonObjectMapper().writeValueAsString(mapOf("test" to "test"))
        producer.send(ProducerRecord("fn-invoice.invoice-confirmed", mapper))


        val consumer = configureConsumer()
        val record = KafkaTestUtils.getSingleRecord(consumer, "fn-invoice.invoice-confirmed")
        println(record.value())
    }

    private fun configureProducer(): Producer<String, String> {
        val producerProps: Map<String, Any> = HashMap(KafkaTestUtils.producerProps(embeddedKafkaBroker))
        return DefaultKafkaProducerFactory<String, String>(producerProps).createProducer()
    }
}

@Component
class KafkaProducer(){

}