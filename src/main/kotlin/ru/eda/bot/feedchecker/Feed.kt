package ru.eda.bot.feedchecker

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "yml_catalog")
data class Feed(

    @JacksonXmlProperty(localName = "shop")
    val shop: Shop?
)

data class Shop(

    @JacksonXmlProperty(localName = "name")
    val name: String?,

    @JacksonXmlProperty(localName = "company")
    val company: String?,

    @JacksonXmlProperty(localName = "url")
    val url: String?,

    @JacksonXmlProperty(localName = "currencies")
    val currencies: List<Currency>?,

    @JacksonXmlProperty(localName = "categories")
    val categories: List<Category>?,

    @JacksonXmlProperty(localName = "offers")
    val offers: List<Offer>?
)

class Currency
class Category

data class Offer(

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: String?,

    @JacksonXmlProperty(localName = "url")
    val url: String?,

    @JacksonXmlProperty(localName = "categoryId")
    val categoryId: String?,

    @JacksonXmlProperty(localName = "name")
    val name: String?,

    @JacksonXmlProperty(localName = "model")
    val model: String?,

    @JacksonXmlProperty(localName = "typePrefix")
    val typePrefix: String?,

    @JacksonXmlProperty(localName = "vendor")
    val vendor: String?,

    @JacksonXmlProperty(localName = "title")
    val title: String?
)
