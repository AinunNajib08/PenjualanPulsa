/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxcelldestop;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author USER
 */
public class SendSMSApp {
    public static  void  main(String[] args) throws IOException {
        JsonObject object = new JsonObject();
        object.add("no", new JsonPrimitive("081235655001"));
        object.add("pesab", new JsonPrimitive("pulsa anda terkirim"));
        
        Gson gson = new Gson();
        String json = gson.toJson(object);
        
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://192.168.43.1:8000");
        post.setEntity(new StringEntity(json));
        httpClient.execute(post);
        
        
}
}