package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import payload.ResponseDTO;
import payload.UrlDTO;
import service.YouTubeService;

import java.io.File;
import java.util.List;

public class ApplicationBot extends TelegramLongPollingBot {
    private final String USERNAME = "YoutTvideosBot";
    private final String TOKEN = "5246333435:AAERUS6u7pIAUX7JL6WqWBX_LopECdT6n7o";


    @Override
    public String getBotUsername() {
        return this.USERNAME;
    }

    @Override
    public String getBotToken() {
        return this.TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        YouTubeService youTubeService = new YouTubeService();
        if (update.getMessage() != null && update.hasMessage()) {
            Message message = update.getMessage();
            String text = message.getText();
            long chat_id = message.getChatId();

            if (text.equals("/start")) {
                SendMessage sendMessage = new SendMessage(String.valueOf(chat_id), "Menga You Tube video linkini yubroing");
                executeSendMessage(sendMessage);
            } else {
                try {
                    ResponseDTO responseDTO=youTubeService.saveVideo(text);
                    String video_path=youTubeService.video_save(responseDTO.getBody().getUrl().get(0).getUrl(),chat_id);
                    SendVideo sendVideo=new SendVideo();
                    sendVideo.setChatId(String.valueOf(chat_id));
                    sendVideo.setVideo(new InputFile(new File(video_path)));
                    sendVideo.setCaption(responseDTO.getBody().getMeta().getTitle()+"\n\n\n"+
                            responseDTO.getBody().getMeta().getTags()+"\n\n\n"+
                            text);

                    execute(sendVideo);

                } catch (Exception e) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(String.valueOf(chat_id));
                    sendMessage.setText("Bu url xato");
                    executeSendMessage(sendMessage);
                }
            }

        }

    }


    public void executeSendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
