package icns.smartplantdashboardapi.dto.sensorData;

import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.dto.sensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.dto.sensorManage.SensorManageSimpleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataResponse {
    private Long dataId;

    private float inputData;

    private LocalDateTime createdAt;

    private SensorManageResponse sensorManage;

    private Integer sensorState;

    public SensorDataResponse(SensorData sensorData){
        this.dataId = sensorData.getDataId();
        this.sensorManage = new SensorManageResponse(sensorData.getSensorManage());
        this.inputData = sensorData.getInputData();
        this.createdAt = sensorData.getCreatedAt();
        this.sensorState = sensorData.getSensorManage().getSensorState();

    }


}
