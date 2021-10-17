package icns.smartplantdashboardapi.dto.sensorData;

import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.domain.SensorManage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataRequest {
    private Long sensorManageId;

    private float inputData;

    public SensorData toEntity(SensorManage sensorManage){
        return SensorData.builder()
                .inputData(inputData)
                .sensorManage(sensorManage)
                .build();
    }
}
