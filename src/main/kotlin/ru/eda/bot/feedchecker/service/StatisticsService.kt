package ru.eda.bot.feedchecker.service

import ru.eda.bot.feedchecker.domain.Feed


object StatisticsService {


    fun getStatistics(feed: Feed): String {
        val shop = feed.shop
        return """ 
            Offers: ${shop?.offers?.size ?: 0}
            Vendors: ${shop?.offers?.filter { it.vendor != null }?.size ?: 0}
            Parameters in offer:  ${shop?.offers?.filter { it.parameters != null }?.size ?: 0}
            Articles:  ${shop?.offers?.filter { it.article != null }?.size ?: 0}
            TypePrefixes:  ${shop?.offers?.filter { it.typePrefix != null }?.size ?: 0}
            Models:  ${shop?.offers?.filter { it.model != null }?.size ?: 0}
        """.trimIndent()
    }

}
