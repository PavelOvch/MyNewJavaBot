package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "MyNewJavaBot";
    }

    @Override
    public String getBotToken() {
        return "5764613304:AAHFcPQY6jyL5m-nDMnJ4ypO1MbNyesfXak";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage(); // Сохранение данных
        var user = msg.getFrom();
        var id = user.getId();
//        sendText(id, msg.getText());
        if(msg.getText().equals("/start"))
            sendText(id, "Привет, " + user.getFirstName() + "!");
        else
            sendText(id, "Неизвестная команда, " + user.getFirstName() + "!");
//        System.out.println(update);
//        System.out.println(user.getFirstName() + " пишет " + msg.getText());
    }

//    public void copyMessage(Long who, Integer msgId){
//        CopyMessage cm = CopyMessage.builder()
//                .fromChatId(who.toString())  //Копируем пользователя
//                .chatId(who.toString())      //и отправляем ему обратно
//                .messageId(msgId)            //уточняем какое
//                .build();
//        try {
//            execute(cm);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Кому мы отправляем сообщение
                .text(what).build();    //Содержание сообщения
        try {
            execute(sm);                        //Отправка сообщения
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Любая ошибка будет напечетана здесь
        }
    }


}