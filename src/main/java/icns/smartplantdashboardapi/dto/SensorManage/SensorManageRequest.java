package icns.smartplantdashboardapi.dto.SensorManage;

import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorManageRequest {

    @NotEmpty
    private Long sensorPosId;

    @NotEmpty
    private Long sensorTypeId;

    @NotEmpty
    private String ssName;

    private String ssDtl;

    @NotEmpty
    private String ssContact;
    private String ssContactExt;
    private String ssContactPhone;


    public SensorManage toEntity(SensorPos sensorPos, SensorType sensorType){
        return SensorManage.builder()
                .ssName(ssName)
                .ssDtl(ssDtl)
                .ssContact(ssContact)
                .ssContactExt(ssContactExt)
                .ssContactPhone(ssContactPhone)
                .ssPos(sensorPos)
                .ssType(sensorType)
                .build();

    }

}
