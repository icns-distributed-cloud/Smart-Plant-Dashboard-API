package icns.smartplantdashboardapi.dto.abnormalDetection;

import icns.smartplantdashboardapi.domain.AbnormalDetection;
import icns.smartplantdashboardapi.domain.SensorManage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbnormalDetectionRequest {
    @NotEmpty
    private Long sensorManageId;


    public AbnormalDetection toEntity(SensorManage sensorManage){
        return AbnormalDetection.builder()
                .sensorManage(sensorManage)
                .sensorState(sensorManage.getSensorState())
                .build();
    }
}
