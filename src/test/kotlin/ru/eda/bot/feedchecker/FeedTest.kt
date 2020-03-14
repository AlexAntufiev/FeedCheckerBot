package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FeedTest {

    @Test
    fun test() {

        val readText = this.javaClass.classLoader.getResource("fail1.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop must not be null")
    }

}