package ru.eda.bot.feedchecker

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.GetFile
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import ru.eda.bot.feedchecker.service.HttpClient
import ru.eda.bot.feedchecker.service.MessageService


class FeedCheckerBot(private val token: String) : TelegramLongPollingBot() {
    /**
     * Return bot username of this bot
     */
    override fun getBotUsername() = "FeedCheckerBot"

    /**
     * Returns the token of the bot to be able to perform Telegram Api Requests
     * @return Token of the bot
     */
    override fun getBotToken() = token

    /**
     * This method is called when receiving updates via GetUpdates method
     * @param update Update received
     */
    override fun onUpdateReceived(update: Update?) {
        println("Get update: $update")
        update?.message?.let { message ->

            when {
                message.hasDocument() -> {
                    if (message.document.mimeType == "application/xml") {
                        val fileText = downloadFile(execute(GetFile().setFileId(message.document?.fileId))).readText()
                        val sendMessages = MessageService.handle(fileText)

                        message.send(sendMessages)
                    } else {
                        message.send("Meow! Only xml file extension is supported")
                    }
                }
                message.hasText() -> {


                    val sendMessages = HttpClient.request(message.text)
                        ?.let { MessageService.handle(it) }
                        ?: listOf("Meow! Can't get data from url")

                    message.send(sendMessages)
                }
                else -> {
                    println("Skip update handling")
                    message.send("Meow! Send URL or xml file with feed to check!")
                }
            }
        }
    }

    private fun Message.send(message: String) = this.send(listOf(message))

    private fun Message.send(messages: List<String>) {
        try {
            messages.forEach { message ->
                if (message.length < MAX_MESSAGE_LENGTH) {
                    execute(SendMessage()
                        .setChatId(this.chatId)
                        .setText(message))
                } else {
                    val file = java.io.File("file.txt")
                    file.writeText(message)
                    execute(SendDocument()
                        .setDocument(file)
                        .setChatId(this.chatId))
                }
            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val MAX_MESSAGE_LENGTH = 4000
    }
}