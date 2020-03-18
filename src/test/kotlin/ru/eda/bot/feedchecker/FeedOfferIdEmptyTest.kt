package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FeedOfferIdEmptyTest {

    @Test
    fun test() {

        val readText = this.javaClass.classLoader.getResource("offerIdEmptyFail.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "id must be not empty")
    }

}