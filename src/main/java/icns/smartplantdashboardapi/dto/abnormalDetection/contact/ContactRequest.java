package icns.smartplantdashboardapi.dto.abnormalDetection.contact;

import icns.smartplantdashboardapi.domain.Contact;
import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.domain.SensorManage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String name;
    private String phone;

    public Contact toEntity(){
        return Contact.builder()
                .name(name)
                .phone(phone)
                .build();
    }
}




