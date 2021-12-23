package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.Contact;
import icns.smartplantdashboardapi.domain.MailLog;
import icns.smartplantdashboardapi.domain.MessageLog;
import icns.smartplantdashboardapi.domain.SopDetailContent;
import icns.smartplantdashboardapi.repository.ContactRepository;
import icns.smartplantdashboardapi.repository.MailLogRepository;
import icns.smartplantdashboardapi.repository.MessageLogRepository;
import icns.smartplantdashboardapi.repository.SopDetailContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final ContactRepository contactRepository;
    private final MailLogRepository mailLogRepository;
    private final SopDetailContentRepository sopDetailContentRepository;

    private final JavaMailSender javaMailSender;

    public List<String> sendMail(String name, Long contentId){
        SopDetailContent sopDetailContent = sopDetailContentRepository.findById(contentId).get();
        List<Contact> contactList = contactRepository.findBySsPos_PosIdAndLevelLessThanEqual(sopDetailContent.getSsPos().getPosId(), sopDetailContent.getSopDetail().getLevel());

        ArrayList<String> toUserList = new ArrayList<>();

        for(Contact contact : contactList){
            toUserList.add(contact.getEmail());


        }

        int toUserSize = toUserList.size();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));

        simpleMailMessage.setSubject("[테스트 메일] 상황 : "+sopDetailContent.getSopDetail().getSituation().getName()+", 레벨 : "+sopDetailContent.getSopDetail().getLevel().toString());

        simpleMailMessage.setText(sopDetailContent.getInfo());

        javaMailSender.send(simpleMailMessage);

        for(Contact contact : contactList){
            toUserList.add(contact.getEmail());

            MailLog mailLog = MailLog.builder()
                    .send(true)
                    .sender(name)
                    .receiver(contact.getName())
                    .text(sopDetailContent.getInfo())
                    .build();
            mailLogRepository.save(mailLog);


        }


        return toUserList;
    }

    @Transactional(readOnly = true)
    public Page<MailLog> findAll(Pageable pageable){
        Page<MailLog> mailLogList = mailLogRepository.findAll(pageable);
        return mailLogList;
    }

}
