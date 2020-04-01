package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.eda.bot.feedchecker.service.FeedValidator
import ru.eda.bot.feedchecker.service.TextParser

class OfferTest {

    @Test
    fun offer_id_null() {

        val readText = this.javaClass.classLoader.getResource("offer/offer_id_null.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals(
            "must not be blank:\n" +
                "    shop.offers.id in 1 offers:\n" +
                "        Offer urls: https://stroicafe.ru/oboi-pod-pokrasku/steklooboi/wellton/decor-fizalis-wd786\n",
            validate)
    }

    @Test
    fun offer_id_empty() {

        val readText = this.javaClass.classLoader.getResource("offer/offer_id_empty.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals(
            "must not be blank:\n" +
                "    shop.offers.id in 1 offers:\n" +
                "        Offer urls: https://stroicafe.ru/oboi-pod-pokrasku/steklooboi/wellton/decor-fizalis-wd786\n",
            validate)
    }

    @Test
    fun offer_url_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("offer/offer_url_textEmpty.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.offers.url in 1 offers:\n" +
            "        Offer ids: 121\n", validate)
    }

    @Test
    fun offer_url_null() {

        val readText = this.javaClass.classLoader.getResource("offer/offer_url_null.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.offers.url in 1 offers:\n" +
            "        Offer ids: 121\n", validate)
    }

    @Test
    fun offer_categoryId_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("offer/offer_categoryId_textEmpty.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.offers.categoryId in 1 offers:\n" +
            "        Offer ids: 123\n", validate)
    }

    @Test
    fun offer_categoryId_null() {

        val readText = this.javaClass.classLoader.getResource("offer/offer_categoryId_null.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.offers.categoryId in 1 offers:\n" +
            "        Offer ids: 123\n", validate)
    }


    @Test
    fun offer_name_size() {

        val readText = this.javaClass.classLoader.getResource("offer/offer_name_size.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("size must be between 1 and 30:\n" +
            "    shop.offers.name in 1 offers:\n" +
            "        Offer ids: 343\n", validate)
    }

}