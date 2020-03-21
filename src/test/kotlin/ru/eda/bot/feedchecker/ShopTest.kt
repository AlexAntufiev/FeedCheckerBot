package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.eda.bot.feedchecker.service.FeedValidator
import ru.eda.bot.feedchecker.service.TextParser

class ShopTest {

    @Test
    fun shop_name_null() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_name_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.name", validate)
    }

    @Test
    fun shop_name_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_name_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.name", validate)
    }

    @Test
    fun shop_company_null() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_company_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.company", validate)
    }

    @Test
    fun shop_company_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_company_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.company", validate)
    }

    @Test
    fun shop_url_null() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_url_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.url", validate)
    }

    @Test
    fun shop_url_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_url_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be blank:\n" +
            "    shop.url", validate)
    }

    @Test
    fun shop_currencies_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_currencies_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be empty:\n" +
            "    shop.currencies", validate)
    }

    @Test
    fun shop_categories_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_categories_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be empty:\n" +
            "    shop.categories", validate)
    }

    @Test
    fun shop_offers_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shop/shop_offers_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be empty:\n" +
            "    shop.offers", validate)
    }
}