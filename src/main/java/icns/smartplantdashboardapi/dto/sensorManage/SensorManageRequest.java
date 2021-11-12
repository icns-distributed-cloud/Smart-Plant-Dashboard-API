package icns.smartplantdashboardapi.dto.sensorManage;

import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SensorType;
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

    private String ssContact;

    private String ssContactExt;

    private String ssContactPhone;


    public SensorManage toEntity(SensorPos sensorPos, SensorType sensorType){
        return SensorManage.builder()
                .ssContact(ssContact)
                .ssContactExt(ssContactExt)
                .ssContactPhone(ssContactPhone)
                .ssPos(sensorPos)
                .ssType(sensorType)
                .rstart(0)
                .rlev1(20)
                .rlev2(40)
                .rlev3(60)
                .rlev4(80)
                .rend(100)
                .sensorState(0)
                .build();

    }

}
