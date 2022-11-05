package com.mycompany.bot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EchoBot extends TelegramLongPollingBot {

    DadosBot dadosBot = new DadosBot();

    @Override
    public String getBotToken() {
        return dadosBot.getBOT_TOKEN();
    }
    
    @Override
    public String getBotUsername() {
        return dadosBot.getBOT_USER_NAME();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            var mensagem = responder(update);
            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage responder(Update update) {
        var textoMensagem = update.getMessage().getText().toLowerCase();
        var chatId = update.getMessage().getChatId().toString();
        String resposta = "";

        //DENTRO DOS IF E ELSE IF, COLOCAMOS QUAL A MENSAGEM GATILHO E A RESPOSTA
        //VEM DENTRO DAS CHAVES;
        if ("/start".equals(textoMensagem)) {
            resposta = "Olá, meu nome é Sentinel! Espero poder lhe ajudar!\n\n"
                    + "Possuo no momento, estes comandos: "
                    + "\n- Olá\n- /help"
                    + "\nEstou sempre sendo atualizado e implementando novas "
                    + "funcionalidades, fique de olho em!";
        }else if (textoMensagem.startsWith("ola") || textoMensagem.startsWith("olá")) {
            resposta = "Olá, meu nome é Sentinel! Espero poder lhe ajudar!";
        } else if (textoMensagem.startsWith("/help")) {
            resposta = "Possuo no momento, estes comandos: "
                    + "\n- Olá\n- /help"
                    + "\nEstou sempre sendo atualizado e implementando novas "
                    + "funcionalidades, fique de olho em!";
        }else{
            resposta = "Desculpe, não entendi o que você quis dizer! "
                    + "Poderia digitar '/help' e ver os comandos que possuo "
                    + "disponíveis?";
        }

        return SendMessage.builder()
                .text(resposta)
                .chatId(chatId)
                .build();
    }

    //CASO FOR NECESSÁRIO CRIAR MÉTODOS PARA UTILIZAR COMO RESPOSTA, CRIEMOS 
    //EM OUTRA CLASSE, PARA SEGUIR UMA ESTRUTURA ORIENTADA A OBJETOS;
}
