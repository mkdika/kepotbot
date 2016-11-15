package com.mkdika.kepotbot.bot;

import com.mkdika.kepotbot.config.BotConfig;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author maikel
 */
public class KepotBotV1Handlers extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        //check if the update has a message
        if (update.hasMessage()) {
            Message message = update.getMessage();
            
            
                        
            //check if the message has text. it could also contain for example a location ( message.hasLocation() )
            if (message.hasText() ) {
                //create an object that contains the information to send back the message
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString()); //who should get from the message the sender that sent it.
                sendMessageRequest.setReplyToMessageId(message.getMessageId());
                sendMessageRequest.setText("Halo, " + update.getMessage().getFrom().getFirstName()
                        +" "+update.getMessage().getFrom().getLastName()+"\nCemana, baek nya kau hari ini?");
                try {
                    sendMessage(sendMessageRequest); //at the end, so some magic and send the message ;)
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }
}
