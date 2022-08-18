package me.ocean.kotlintemplate.entitylistener

import me.ocean.kotlintemplate.entitylistener.entity.PersonHistory
import org.springframework.data.jpa.repository.JpaRepository

interface PersonHistoryRepository: JpaRepository<PersonHistory, Long> {
}