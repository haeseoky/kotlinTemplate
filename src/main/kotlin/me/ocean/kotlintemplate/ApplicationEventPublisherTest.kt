package me.ocean.kotlintemplate

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Component
class ApplicationEventPublisherTest(
    private val eventPublisher: EventPublisher,
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {

//        eventPublisher.eventPublish()
        eventPublisher.transactionalEventPublish()
    }
}

@Component
class EventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
){
    fun eventPublish() {
        val event = Event("event", "event publish test")

        println("eventPublish() start")
        Thread.sleep(1000)
        applicationEventPublisher.publishEvent(event)
        Thread.sleep(1000)
        println("eventPublish() published")
    }

    @Transactional
    fun transactionalEventPublish() {
        val event = Event("event", "event publish test")

        println("transactionalEventPublish() start")
        Thread.sleep(1000)
        applicationEventPublisher.publishEvent(event)
        Thread.sleep(1000)
        println("transactionalEventPublish() published")
    }
}
@Component
class MyEventListener(){
    @EventListener
    fun eventListener(event: Event) {
        println("event listen : $event")
    }

    @TransactionalEventListener
    fun transactionalEventListener(event: Event) {
        println("transactional event listen : $event")
    }
}

data class Event(
    val name: String,
    val description: String,
)
