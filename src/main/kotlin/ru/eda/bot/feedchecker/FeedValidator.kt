package ru.eda.bot.feedchecker

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

class FeedValidator {

    companion object {

        private val kotlinXmlMapper = XmlMapper(JacksonXmlModule())
            .registerKotlinModule()
            .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            .enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    fun validate(it: String): String {

        try {
            val feed = kotlinXmlMapper.readValue<Feed>(it)

            //TODO добвить проверки

        } catch (e: RuntimeException) {
            return "Unexpected error: ${e.localizedMessage}"
        }

        return "Your feed is valid"
    }
}