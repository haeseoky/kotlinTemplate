package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.entity.PersonHistory
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