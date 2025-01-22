package com.project.telegram_bot.config;

import com.project.telegram_bot.service.telegram.TelegramBotApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramBotConfig {
    private static final String EXCEPTION_MESSAGE
            = "Error when registering the Telegram bot, check the token in the env file";

    private final TelegramBotApi telegramBot;

    @Autowired
    public TelegramBotConfig(TelegramBotApi telegramBot) { // явний конструктор
        this.telegramBot = telegramBot;
    }
    @Bean
    public TelegramBotsApi telegramBotsApi() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(telegramBot);
            return botsApi;
        } catch (TelegramApiException e) {
            throw new RuntimeException(
                    EXCEPTION_MESSAGE, e);
        }
    }
}
