package icns.smartplantdashboardapi.dto.abnormalDetection;

import icns.smartplantdashboardapi.domain.AbnormalDetection;
import icns.smartplantdashboardapi.domain.SensorManage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbnormalDetectionRequest {
    @NotEmpty
    private Long sensorManageId;

    @NotEmpty
    private String state;


    public AbnormalDetection toEntity(SensorManage sensorManage){
        return AbnormalDetection.builder()
                .sensorManage(sensorManage)
                .state(state)
                .build();
    }
}
