package me.ocean.kotlintemplate.entitylistener

import me.ocean.kotlintemplate.entitylistener.entity.PersonHistory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PersonHistoryService (
    private val personHistoryRepository: PersonHistoryRepository,
        ){

    fun create(personHistory: PersonHistory){
        throw RuntimeException("not implemented")
        personHistoryRepository.save(personHistory)

    }
}