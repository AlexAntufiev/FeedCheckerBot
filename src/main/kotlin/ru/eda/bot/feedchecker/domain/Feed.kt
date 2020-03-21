package ru.eda.bot.feedchecker.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import javax.validation.Valid
import javax.validation.constraints.NotNull

@JacksonXmlRootElement(localName = "yml_catalog")
data class Feed(

    @field:Valid
    @field:NotNull
    @JacksonXmlProperty(localName = "shop")
    val shop: Shop?
)
