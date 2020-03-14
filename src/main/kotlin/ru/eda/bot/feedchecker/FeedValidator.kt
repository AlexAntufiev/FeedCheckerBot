package ru.eda.bot.feedchecker

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import javax.validation.Validation

class FeedValidator {

    companion object {

        private val kotlinXmlMapper = XmlMapper(JacksonXmlModule())
            .registerKotlinModule()
            .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            .enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

        private val validator = Validation.buildDefaultValidatorFactory().validator
    }

    fun validate(it: String): String {

        return try {
            val feed = kotlinXmlMapper.readValue<Feed>(it)

            //TODO добвить проверки
            val validate = validator.validate(feed).joinToString{
                violation -> "${violation.propertyPath} ${violation.message}"
            }

            if (validate.isEmpty()) {
                return "Your feed is valid"
            } else validate

        } catch (e: RuntimeException) {
            "Unexpected error: ${e.localizedMessage}"
        }

        return "Your feed is valid"
    }
}