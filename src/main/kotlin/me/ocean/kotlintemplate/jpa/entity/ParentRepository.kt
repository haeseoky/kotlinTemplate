package me.ocean.kotlintemplate.jpa.entity

import org.springframework.data.jpa.repository.JpaRepository

interface ParentRepository: JpaRepository<Parent, Long> {
}