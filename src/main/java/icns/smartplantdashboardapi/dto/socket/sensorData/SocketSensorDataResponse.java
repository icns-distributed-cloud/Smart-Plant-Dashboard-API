package icns.smartplantdashboardapi.dto.socket.sensorData;

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
        this.sensorState = sensorData.getSensorManage().getSensorState();
    }
}
