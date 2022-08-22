package me.ocean.kotlintemplate.jpa.entity

import org.springframework.data.jpa.repository.JpaRepository

interface ChildRepository:JpaRepository<Child, Long> {

}