package me.ocean.kotlintemplate.jpa.entity

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class JpaService(
    private val parentRepository: ParentRepository,
    private val childRepository: ChildRepository
) {

    fun saveParent(parent: Parent): Parent {
        return parentRepository.save(parent)
    }

    fun saveChild(child: Child): Child {
        return childRepository.save(child)
    }

    fun update(id: Long): Parent {
        val findById = parentRepository.findById(id).get()
        findById.name = "testestest"
        return parentRepository.save(findById)
    }

}