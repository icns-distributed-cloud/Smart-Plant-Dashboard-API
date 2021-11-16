package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.Contact;
import icns.smartplantdashboardapi.dto.abnormalDetection.contact.ContactRequest;
import icns.smartplantdashboardapi.dto.abnormalDetection.contact.ContactResponse;
import icns.smartplantdashboardapi.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    @Transactional(readOnly = true)
    public Page<ContactResponse> findAll(Pageable pageable){
        Page<ContactResponse> contactList = contactRepository.findAll(pageable).map(ContactResponse::new);
        return contactList;
    }

    @Transactional
    public Long save(ContactRequest contactRequest){
        Contact saved = contactRepository.save(contactRequest.toEntity());
        return saved.getId();
    }


}
