package icns.smartplantdashboardapi.dto.socket;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SocketSensorDataResponse {
    private Long ssId;
    private Long inputData;
}
