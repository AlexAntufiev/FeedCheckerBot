package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.eda.bot.feedchecker.service.StatisticsService
import ru.eda.bot.feedchecker.service.TextParser


internal class StatisticsServiceTest {

    @Test
    fun getStatistics() {

        val readText = this.javaClass.classLoader.getResource("feed/success.xml")?.readText()
            ?: throw IllegalArgumentException("Path not found")
        val feed = TextParser.parse(readText) ?: throw IllegalArgumentException("Can't parse")

            val statistics = StatisticsService.getStatistics(feed)

        assertEquals(statistics, """
            Offers: 10
            Vendors: 5
            Parameters in offer:  9
            Articles:  8
        """.trimIndent())
    }
}