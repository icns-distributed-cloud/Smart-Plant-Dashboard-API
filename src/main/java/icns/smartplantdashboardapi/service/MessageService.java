package icns.smartplantdashboardapi.service;


import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MessageService {

    @Value("${icns.app.coolsms.apikey}")
    private String apiKey;
    @Value("${icns.app.coolsms.apisecret}")
    private String apiSecret;

    public Long sendMessage(){
        String api_key = apiKey;
        String api_secret = apiSecret;
        Message coolsms = new Message(api_key, api_secret);
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("to", "01097528081");
        params.put("from", "01097528081");
        params.put("type", "SMS");
        params.put("text", "화재 발생");
        params.put("app_version", "test app 1.2");


        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

        return 1L;
    }

}
