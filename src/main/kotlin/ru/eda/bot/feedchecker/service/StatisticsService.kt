package ru.eda.bot.feedchecker.service

import ru.eda.bot.feedchecker.domain.Feed


object StatisticsService {


    fun getStatistics(feed: Feed): String {
        val shop = feed.shop
        return """ 
            Offers: ${shop?.offers?.size}
            Vendors: ${shop?.offers?.filter { it.vendor != null }?.size}
            Parameters in offer:  ${shop?.offers?.filter { it.parameters != null }?.size}
            Articles:  ${shop?.offers?.filter { it.article != null }?.size}
        """.trimIndent()
    }

}
