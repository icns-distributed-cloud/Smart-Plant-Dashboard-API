package icns.smartplantdashboardapi.dto.abnormalDetection.contact;

import icns.smartplantdashboardapi.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    private Long id;
    private String name;
    private String phone;

    public ContactResponse(Contact contact){
        this.id = contact.getId();
        this.name = contact.getName();
        this.phone = contact.getPhone();
    }
}




