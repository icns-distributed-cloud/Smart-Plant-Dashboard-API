package icns.smartplantdashboardapi.controller.socket;

import icns.smartplantdashboardapi.domain.AbnormalDetection;
import icns.smartplantdashboardapi.dto.abnormalDetection.AbnormalDetectionRequest;
import icns.smartplantdashboardapi.dto.abnormalDetection.AbnormalDetectionResponse;
import icns.smartplantdashboardapi.dto.socket.sensorData.SocketSensorDataRequest;
import icns.smartplantdashboardapi.dto.socket.sensorData.SocketSensorDataResponse;
import icns.smartplantdashboardapi.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ws")
@RequiredArgsConstructor
public class SocketController {

    private final SensorDataService sensorDataService;

    @MessageMapping("/receive/{ssId}")
    @SendTo("/send/{ssId}")
    public SocketSensorDataResponse SocketHandler(@DestinationVariable Long ssId){
        return sensorDataService.sendData(ssId);
    }

    @MessageMapping("/check")
    @SendTo("/alert")
    public AbnormalDetectionResponse abnormalSocketHandler(AbnormalDetectionResponse abnormalDetectionResponse){
        return abnormalDetectionResponse;

    }


}
