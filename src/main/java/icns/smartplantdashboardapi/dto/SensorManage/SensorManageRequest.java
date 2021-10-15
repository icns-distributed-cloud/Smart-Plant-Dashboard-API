package icns.smartplantdashboardapi.dto.SensorManage;

import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorManageRequest {

    private Long sensorPosId;
    private String ssName;
    private String ssDtl;
    private String ssContact;
    private String ssContactExt;
    private String ssContactPhone;
    @Setter
    private SensorPos ssPos;

    public SensorManage toEntity(){
        return SensorManage.builder()
                .ssName(ssName)
                .ssDtl(ssDtl)
                .ssContact(ssContact)
                .ssContactExt(ssContactExt)
                .ssContactPhone(ssContactPhone)
                .ssPos(ssPos)
                .build();

    }

}
