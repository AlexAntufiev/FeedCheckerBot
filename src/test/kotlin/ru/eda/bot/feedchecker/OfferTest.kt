package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OfferTest {

    @Test
    fun offer_id_null() {

        val readText = this.javaClass.classLoader.getResource("offerXMLs.offer_id_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].id must not be blank")
    }

    @Test
    fun offer_id_empty() {

        val readText = this.javaClass.classLoader.getResource("offerXMLs.offer_id_empty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].id must not be blank")
    }

    @Test
    fun offer_url_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("offerXMLs.offer_url_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].url must not be empty")
    }

    @Test
    fun offer_url_null() {

        val readText = this.javaClass.classLoader.getResource("offerXMLs.offer_url_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].url must not be empty")
    }

    @Test
    fun offer_categoryId_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("offerXMLs.offer_categoryId_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].categoryId must not be empty")
    }

    @Test
    fun offer_categoryId_null() {

        val readText = this.javaClass.classLoader.getResource("offerXMLs.offer_categoryId_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.offers[0].categoryId must not be empty")
    }

}