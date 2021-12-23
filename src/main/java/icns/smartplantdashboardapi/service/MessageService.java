package icns.smartplantdashboardapi.service;


import icns.smartplantdashboardapi.domain.Contact;
import icns.smartplantdashboardapi.domain.SopDetailContent;
import icns.smartplantdashboardapi.domain.MessageLog;
import icns.smartplantdashboardapi.repository.ContactRepository;
import icns.smartplantdashboardapi.repository.SopDetailContentRepository;
import icns.smartplantdashboardapi.repository.SopDetailRepository;
import icns.smartplantdashboardapi.repository.MessageLogRepository;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final ContactRepository contactRepository;
    private final MessageLogRepository messageLogRepository;
    private final SopDetailContentRepository sopDetailContentRepository;


    @Value("${icns.app.coolsms.apikey}")
    private String apiKey;

    @Value("${icns.app.coolsms.apisecret}")
    private String apiSecret;

    @Value("${icns.app.coolsms.phone}")
    private String phone;


    public List<String> sendMessage(String name, Long contentId){
        SopDetailContent sopDetailContent = sopDetailContentRepository.findById(contentId).get();
        List<Contact> contactList = contactRepository.findBySsPos_PosIdAndLevelLessThanEqual(sopDetailContent.getSsPos().getPosId(), sopDetailContent.getSopDetail().getLevel());

        List<String> phoneList = new ArrayList<>();

        for(Contact contact : contactList){
            String api_key = apiKey;
            String api_secret = apiSecret;
            Message coolsms = new Message(api_key, api_secret);

            phoneList.add(contact.getPhone());


            HashMap<String, String> params = new HashMap<String, String>();

            params.put("to", contact.getPhone());
            params.put("from", phone);
            params.put("type", "SMS");
            params.put("text", sopDetailContent.getInfo());
            params.put("app_version", "test app 1.2");



            try {
                JSONObject obj = (JSONObject) coolsms.send(params);
                System.out.println(obj.toString());
                MessageLog messageLog = MessageLog.builder()
                        .send(true)
                        .sender(name)
                        .receiver(contact.getName())
                        .text(sopDetailContent.getInfo())
                        .build();
                messageLogRepository.save(messageLog);

            } catch (CoolsmsException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCode());
                MessageLog messageLog = MessageLog.builder()
                        .send(false)
                        .sender(name)
                        .receiver(contact.getName())
                        .text(sopDetailContent.getInfo())
                        .build();
                messageLogRepository.save(messageLog);
            }
        }


        return phoneList;
    }


    @Transactional(readOnly = true)
    public Page<MessageLog> findAll(Pageable pageable){
        Page<MessageLog> messageLogList = messageLogRepository.findAll(pageable);
        return messageLogList;
    }
}
