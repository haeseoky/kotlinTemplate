package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.entity.PersonHistory
import org.springframework.data.jpa.repository.JpaRepository

interface PersonHistoryRepository: JpaRepository<PersonHistory, Long> {
}