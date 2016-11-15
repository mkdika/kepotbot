package com.mkdika.kepotbot;

import com.mkdika.kepotbot.bot.KepotBotV1Handlers;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author maikel
 */
public class Main {

    public static void main(String[] args) {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new KepotBotV1Handlers());           
        } catch (TelegramApiException e) {
             e.printStackTrace();
        }
    }

}
