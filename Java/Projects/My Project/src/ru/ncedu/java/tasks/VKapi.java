package ru.ncedu.java.tasks;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

public class VKapi {
    private String client_id = "4625532";
    private String scope = "messages";
    private String redirect_uri = "http://oauth.vk.com/blank.html";
    private String display = "popup";
    private String response_type = "token";
    private String access_token;
    private String email = "alexandr.koromyslov@gmail.com";//тут должен быть прописан email
    private String pass = "nokia3720classic";//тут должен быть прописан пароль

    public void setConnection() throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
// Делаем первый запрос
        HttpPost post = new HttpPost("http://oauth.vk.com/authorize?" +
                "client_id="+client_id+
                "&scope="+scope+
                "&redirect_uri="+redirect_uri+
                "&display="+display+
                "&response_type="+response_type);
        HttpResponse response;
        response = httpClient.execute(post);
        post.abort();
//Получаем редирект
        String HeaderLocation = response.getFirstHeader("location").getValue();
        URI RedirectUri = new URI(HeaderLocation);
//Для запроса авторизации необходимо два параметра полученных в первом запросе
//ip_h и to_h
        String ip_h= RedirectUri.getQuery().split("&")[2].split("=")[1];
        String to_h=RedirectUri.getQuery().split("&")[4].split("=")[1];
// Делаем запрос авторизации
        post = new HttpPost("https://login.vk.com/?act=login&soft=1"+
                "&q=1"+
                "&ip_h="+ip_h+
                "&from_host=oauth.vk.com"+
                "&to="+to_h+
                "&expire=0"+
                "&email="+email+
                "&pass="+pass);
        response = httpClient.execute(post);
        post.abort();
// Получили редирект на подтверждение требований приложения
        HeaderLocation = response.getFirstHeader("location").getValue();
        post = new HttpPost(HeaderLocation);
// Проходим по нему
        response = httpClient.execute(post);
        post.abort();
// Теперь последний редирект на получение токена
        HeaderLocation = response.getFirstHeader("location").getValue();
// Проходим по нему
        post = new HttpPost(HeaderLocation);
        response = httpClient.execute(post);
        post.abort();
// Теперь в след редиректе необходимый токен
        HeaderLocation = response.getFirstHeader("location").getValue();
// Просто спарсим его сплитами
        access_token = HeaderLocation.split("#")[1].split("&")[0].split("=")[1];
    }
    public String getNewMessage() throws ClientProtocolException, IOException, NoSuchAlgorithmException, URISyntaxException {
        String url = "https://api.vk.com/method/"+
                "messages.get"+
                "?out=0"+
                "&access_token="+access_token
                ;
        String line = "";
        try {
            URL url2 = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream()));
            line = reader.readLine();
            reader.close();

        } catch (MalformedURLException e) {
            // ...
        } catch (IOException e) {
            // ...
        }
        return line;
    }
}

