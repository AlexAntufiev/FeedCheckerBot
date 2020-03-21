package ru.eda.bot.feedchecker.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class Shop(

    @field:NotBlank
    @JacksonXmlProperty(localName = "name")
    val name: String?,

    @field:NotBlank
    @JacksonXmlProperty(localName = "company")
    val company: String?,

    @field:NotBlank
    @JacksonXmlProperty(localName = "url")
    val url: String?,

    @field:NotEmpty
    @field:Valid
    @JacksonXmlProperty(localName = "currencies")
    val currencies: List<Currency>?,

    @field:NotEmpty
    @field:Valid
    @JacksonXmlProperty(localName = "categories")
    val categories: List<Category>?,

    @field:NotEmpty
    @field:Valid
    @JacksonXmlProperty(localName = "offers")
    val offers: List<Offer>?
)