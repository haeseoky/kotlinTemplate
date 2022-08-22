package me.ocean.kotlintemplate.jpa.entity

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class JpaService(
    private val parentRepository: ParentRepository,
    private val childRepository: ChildRepository
) {

    fun save(){
        val parent = Parent(
            name = "ocean"
        )

        parentRepository.save(parent)
    }

    fun update(id: Long): Parent {
        val findById = parentRepository.findById(id).get()
        findById.name = "testestest"
        return parentRepository.save(findById)
    }

}