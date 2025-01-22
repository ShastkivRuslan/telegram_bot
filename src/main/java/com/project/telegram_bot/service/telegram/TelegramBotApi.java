package com.project.telegram_bot.service.telegram;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotApi extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "RuslanShastkivBot";
    }

    @Override
    public String getBotToken() {
        return "8159315366:AAG-LBpyH8kDC7maSUWPr-FnUqcDQ8svpF0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var chatId = msg.getChatId().toString();

        sendMessage(chatId, "hello!");
    }

    private void sendMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
