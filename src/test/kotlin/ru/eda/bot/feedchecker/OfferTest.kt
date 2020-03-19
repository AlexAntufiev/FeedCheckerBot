package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OfferTest {

    @Test
    fun offer_id_null() {

        val readText = this.javaClass.classLoader.getResource("offer_id_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].id must not be blank")
    }

    @Test
    fun offer_id_empty() {

        val readText = this.javaClass.classLoader.getResource("offer_id_empty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].id must not be blank")
    }

}