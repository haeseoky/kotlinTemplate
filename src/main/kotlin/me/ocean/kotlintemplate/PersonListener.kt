package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.entity.Person
import me.ocean.kotlintemplate.entity.PersonHistory
import javax.persistence.*


class PersonListener(

) {

    @PostLoad
    fun onLoad(person: Person) {
        println("onLoad: $person")
        person.oldName = person.name
        person.oldAge = person.age
    }

    @PostPersist
    fun postPersist(obj: Any) {
        println("postPersist: $obj")
        val person = obj as Person
        val personHistoryRepository = BeanUtils.getBean(PersonHistoryRepository::class.java)
        personHistoryRepository.save(
            PersonHistory(
                "postPersist",
                personId = person.id,
                beforeName = person.oldName,
                afterName = person.name,
                beforeAge = person.oldAge,
                afterAge = person.age,
            )

        )
    }

    @PostUpdate
    fun postUpdate(obj: Any) {
        println("postUpdate: $obj")
        val person = obj as Person
        val personHistoryRepository = BeanUtils.getBean(PersonHistoryRepository::class.java)
        personHistoryRepository.save(
            PersonHistory(
                "postUpdate",
                personId = person.id,
                beforeName = person.oldName,
                afterName = person.name,
                beforeAge = person.oldAge,
                afterAge = person.age,
            )

        )
    }


    @PostRemove
    fun postRemove(obj: Any) {
        println("postRemove: $obj")
        val person = obj as Person
        val personHistoryRepository = BeanUtils.getBean(PersonHistoryRepository::class.java)
        personHistoryRepository.save(
            PersonHistory(
                "postRemove",
                personId = person.id,
                beforeName = person.oldName,
                afterName = "",
                beforeAge = person.oldAge,
                afterAge = 0,
            )

        )
    }

//    @PostUpdate
//    fun postUpdate(obj: Any) {
//        println("postUpdate: $obj")
//    }

//    @PostRemove
//    fun postRemove(obj: Any) {
//        println("postRemove: $obj")
//    }
}