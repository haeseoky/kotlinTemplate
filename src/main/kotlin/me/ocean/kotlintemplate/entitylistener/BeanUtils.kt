package me.ocean.kotlintemplate.entitylistener

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext

import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component


@Component
class BeanUtils : ApplicationContextAware {
    @Throws(BeansException::class)
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        ac = applicationContext
    }

    companion object {
        private lateinit var ac: ApplicationContext
        fun <T> getBean(clazz: Class<T>): T {
            return ac.getBean(clazz)
        }
    }
}