package ru.eda.bot.feedchecker.service

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import ru.eda.bot.feedchecker.domain.Feed

object TextParser {

    private val kotlinXmlMapper = XmlMapper(JacksonXmlModule())
        .registerKotlinModule()
        .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
        .enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)


    fun parse(it: String): Feed? {
        println("Parsing text")

        return try {
            val feed = kotlinXmlMapper.readValue<Feed>(it)
            println("Parsed text")
            feed
        } catch (e: RuntimeException) {
            println("Parsing error: $e")
            return null
        }
    }

}