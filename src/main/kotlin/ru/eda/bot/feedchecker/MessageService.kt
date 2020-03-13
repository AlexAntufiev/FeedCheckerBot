package ru.eda.bot.feedchecker


class MessageService(private val validator: FeedValidator = FeedValidator()) {

    fun handle(text: String): String {
        return validator.validate(text)
    }
}