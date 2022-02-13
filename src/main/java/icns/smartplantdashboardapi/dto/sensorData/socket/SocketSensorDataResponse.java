package icns.smartplantdashboardapi.dto.sensorData.socket;

import icns.smartplantdashboardapi.domain.EState;
import icns.smartplantdashboardapi.domain.SensorData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocketSensorDataResponse {
    private Long ssId;
    private float inputData;

    private LocalDateTime createdAt;

    private Integer sensorState;

    public SocketSensorDataResponse(SensorData sensorData){
        this.ssId = sensorData.getSensorManage().getSsId();
        this.inputData = sensorData.getInputData();
        this.createdAt = sensorData.getCreatedAt();
        if(this.inputData > sensorData.getSensorManage().getRlev4()){
            this.sensorState = EState.SERIOUS.ordinal();
        }else if(this.inputData > sensorData.getSensorManage().getRlev3()){
            this.sensorState = EState.WANRNING.ordinal();
        }else if(this.inputData > sensorData.getSensorManage().getRlev2()){
            this.sensorState = EState.CAUTION.ordinal();
        }else if(this.inputData > sensorData.getSensorManage().getRlev1()) {
            this.sensorState = EState.ATTENTION.ordinal();
        }else{
            this.sensorState = EState.SAFE.ordinal();
        }
    }
}
