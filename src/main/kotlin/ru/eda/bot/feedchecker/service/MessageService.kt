package ru.eda.bot.feedchecker.service


object MessageService {

    fun handle(text: String): List<String> {
        println("Handling text")

        val feed = TextParser.parse(text) ?: return listOf("Unexpected error, sorry =)")

        val validationResult = FeedValidator.validate(feed)

        val statistics = StatisticsService.getStatistics(feed)

        println("Handled text")
        return mutableListOf("**ValidationResult**\n$validationResult", "**Statistics**\n$statistics")
    }
}