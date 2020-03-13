package ru.eda.bot.feedchecker

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.GetFile
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


class FeedCheckerBot(private val messageService: MessageService = MessageService()) : TelegramLongPollingBot() {
    /**
     * Return bot username of this bot
     */
    override fun getBotUsername() = "FeedCheckerBot"

    /**
     * Returns the token of the bot to be able to perform Telegram Api Requests
     * @return Token of the bot
     */
    override fun getBotToken() = "empty"

    /**
     * This method is called when receiving updates via GetUpdates method
     * @param update Update received
     */
    override fun onUpdateReceived(update: Update?) {
        update?.message?.let {

            when {
                it.document?.mimeType.equals("application/xml") -> {
                    val fileText = downloadFile(execute(GetFile().setFileId(it.document?.fileId))).readText()
                    val sendMessage = messageService.handle(fileText)

                    it.send(sendMessage)
                }
                else -> it.send("Only xml file extension is supported")
            }
        }
    }

    private fun Message.send(string: String) {
        try {
            execute(SendMessage()
                .setChatId(this.chatId)
                .setText(string))
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}