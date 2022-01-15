package icns.smartplantdashboardapi.controller.socket;

import icns.smartplantdashboardapi.dto.abnormalDetection.socket.SocketAbnormalDetectionResponse;
import icns.smartplantdashboardapi.dto.sensorData.socket.SocketSensorDataResponse;
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
    public SocketSensorDataResponse SocketHandler(@DestinationVariable Long ssId) throws Exception{
        return sensorDataService.sendData(ssId);
    }

    @MessageMapping("/check")
    @SendTo("/alert")
    public SocketAbnormalDetectionResponse abnormalSocketHandler(SocketAbnormalDetectionResponse socketAbnormalDetectionResponse) throws Exception{
        return socketAbnormalDetectionResponse;

    }


}
