package ru.eda.bot.feedchecker.service

import ru.eda.bot.feedchecker.domain.Feed
import ru.eda.bot.feedchecker.domain.Offer
import javax.validation.ConstraintViolation
import javax.validation.Validation

object FeedValidator {

    private val validator = Validation.buildDefaultValidatorFactory().validator

    fun validate(feed: Feed): String {
        println("Validating text")

        return try {

            val validated = validator.validate(feed)

            println("Validated text")

            val validateMessage = validated
                .groupBy { it.message }
                .entries
                .joinToString(separator = "\n") {
                    "${it.key}:\n${modifyConstraints(it.value)}"
                }

            if (validateMessage.isEmpty()) {
                return "Your feed is valid"
            } else validateMessage

        } catch (e: RuntimeException) {
            println("Validating error $e")
            "Unexpected error, sorry =)"
        }
    }

    private fun modifyConstraints(it: List<ConstraintViolation<Feed>>) =
        it.groupBy { violation -> violation.propertyPath.toList().joinToString(separator = ".") { it.name } }
            .entries
            .joinToString(separator = "\n") {
                "    ${it.key}${offerInfo(it.value)}"
            }

    private fun offerInfo(constraints: List<ConstraintViolation<Feed>>): String {
        val feedSequence = constraints
            .map { it.leafBean }
            .filterIsInstance<Offer>()

        if (feedSequence.isEmpty()) {
            return ""
        }

        val ids = mutableListOf<Offer>()
        val urls = mutableListOf<Offer>()
        val names = mutableListOf<Offer>()
        val others = mutableListOf<Offer>()

        feedSequence.filterTo(ids) { it.id.isNullOrBlank().not() }

        feedSequence.filterTo(urls) { it.id.isNullOrBlank() and it.url.isNullOrBlank().not() }

        feedSequence.filterTo(names) { it.id.isNullOrBlank() and it.url.isNullOrBlank() and it.name.isNullOrBlank().not() }

        feedSequence.filterTo(others) { it.id.isNullOrBlank() and it.url.isNullOrBlank() and it.name.isNullOrBlank() }

        val idsMessage = if (ids.isNotEmpty())
            "        Offer ids: ${ids.joinToString { "${it.id}" }}\n" else ""
        val urlsMessage = if (urls.isNotEmpty())
            "        Offer urls: ${urls.joinToString { "${it.url?.trimIndent()}" }}\n" else ""
        val namesMessage = if (names.isNotEmpty())
            "        Offer names: ${names.joinToString { "${it.name?.trimIndent()}" }}\n" else ""
        val othersMessage = if (others.isNotEmpty())
            "        Incorrect offers: ${others.size}\n" else ""

        return " in ${feedSequence.size} offers:\n$idsMessage$urlsMessage$namesMessage$othersMessage"

    }
}