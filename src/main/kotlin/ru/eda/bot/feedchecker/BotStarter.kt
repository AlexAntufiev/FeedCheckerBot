package ru.eda.bot.feedchecker

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


object BotStarter {

    @JvmStatic
    fun main(args: Array<String>) {

        if (args.size != 1) {
            throw IllegalArgumentException("Token must be pass as first argument")
        }

        ApiContextInitializer.init();

        val botsApi = TelegramBotsApi()

        try {
            val token = args[0]
            botsApi.registerBot(FeedCheckerBot(token))
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}