package icns.smartplantdashboardapi.dto.contact;

import icns.smartplantdashboardapi.domain.Contact;
import icns.smartplantdashboardapi.domain.SensorPos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String name;
    private String phone;
    private Long posId;

    public Contact toEntity(SensorPos sensorPos){
        return Contact.builder()
                .name(name)
                .phone(phone)
                .ssPos(sensorPos)
                .build();
    }
}




