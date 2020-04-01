package ru.eda.bot.feedchecker.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class Offer(

    @field:NotBlank
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: String?,

    @field:NotBlank
    @JacksonXmlProperty(localName = "url")
    val url: String?,

    @field:NotBlank
    @JacksonXmlProperty(localName = "categoryId")
    val categoryId: String?,

    @field:Size(min = 1, max = 30)
    @JacksonXmlProperty(localName = "name")
    val name: String?,

    @JacksonXmlProperty(localName = "model")
    val model: String?,

    @JacksonXmlProperty(localName = "typePrefix")
    val typePrefix: String?,

    @JacksonXmlProperty(localName = "vendor")
    val vendor: String?,

    @JacksonXmlProperty(localName = "title")
    val title: String?,

    @JacksonXmlProperty(localName = "param")
    val parameters: String?,

    @JacksonXmlProperty(localName = "article")
    val article: String?

)