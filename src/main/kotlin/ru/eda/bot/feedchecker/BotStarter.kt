package ru.eda.bot.feedchecker

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


object BotStarter {

    @JvmStatic
    fun main(args: Array<String>) {

        ApiContextInitializer.init();

        val botsApi = TelegramBotsApi()

        try {
            botsApi.registerBot(FeedCheckerBot())
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}