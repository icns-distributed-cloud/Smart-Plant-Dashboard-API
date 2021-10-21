package icns.smartplantdashboardapi.dto.socket.sensorData;

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

    public SocketSensorDataResponse(Long ssId, float inputData){
        this.ssId = ssId;
        this.inputData = inputData;
        this.createdAt = LocalDateTime.now();
    }
}
