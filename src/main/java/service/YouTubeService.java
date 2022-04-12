package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import payload.ResponseDTO;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Objects;

public class YouTubeService {
    public ResponseDTO saveVideo(String url){
        ResponseDTO responseDTO=new ResponseDTO();
        Gson gson=new Gson();
        OkHttpClient client = new OkHttpClient();

       //REQUEST

        try {
            Response response = client.newCall(request).execute();
            String jsonData= Objects.requireNonNull(response.body()).string();

            Type type = new TypeToken<ResponseDTO>() {
            }.getType();
            System.out.println(jsonData);
            responseDTO = gson.fromJson(jsonData, type);

            return responseDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String video_save(String url,long chat_id){
        String uploadFolder = "E:\\WORK\\Plus\\Youtube_VideoDownloader\\videos\\" + chat_id + ".mp4";
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(uploadFolder)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            return uploadFolder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadFolder;
    }
}
