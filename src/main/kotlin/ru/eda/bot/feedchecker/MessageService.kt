package ru.eda.bot.feedchecker


class MessageService(private val validator: FeedValidator = FeedValidator()) {

    fun handle(text: String): String {
        println("Handling text")
        val validate = validator.validate(text)
        println("Handled text")
        return validate
    }
}