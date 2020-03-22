package ru.eda.bot.feedchecker.service

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking
import java.net.URI

object HttpClient {

    fun request(url: String): String? {

        kotlin.runCatching { URI.create(url) }.onFailure { return null }

        return runBlocking {
            kotlin.runCatching {
                HttpClient().use { it.get<String>(url) }
            }.getOrNull()
        }
    }

}