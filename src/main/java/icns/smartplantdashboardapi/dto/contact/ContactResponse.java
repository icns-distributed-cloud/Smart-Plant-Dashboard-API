package icns.smartplantdashboardapi.dto.contact;

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
    private Long posId;
    private String posName;

    public ContactResponse(Contact contact){
        this.id = contact.getId();
        this.name = contact.getName();
        this.phone = contact.getPhone();
        this.posId = contact.getSsPos().getPosId();
        this.posName = contact.getSsPos().getPosName();

    }
}




