package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.eda.bot.feedchecker.service.FeedValidator
import ru.eda.bot.feedchecker.service.TextParser

class FeedTest {

    @Test
    fun feed_shop_null() {

        val readText = this.javaClass.classLoader.getResource("feed/feed_shop_null.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals("must not be null:\n" +
            "    shop", validate)
    }

    @Test
    fun successTest() {

        val readText = this.javaClass.classLoader.getResource("feed/success.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")
        val validate = FeedValidator.validate(feed)

        assertEquals(validate, "Your feed is valid")
    }

}