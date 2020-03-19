package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FeedTest {

    @Test
    fun feed_shop_null() {

        val readText = this.javaClass.classLoader.getResource("feed/feed_shop_null.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop must not be null")
    }

    @Test
    fun successTest() {

        val readText = this.javaClass.classLoader.getResource("feed/success.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "Your feed is valid")
    }

}