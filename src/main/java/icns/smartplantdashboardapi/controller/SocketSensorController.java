package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.socket.SocketSensorDataRequest;
import icns.smartplantdashboardapi.dto.socket.SocketSensorDataResponse;
import icns.smartplantdashboardapi.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketSensorController {



    @MessageMapping("/receive")
    @SendTo("/send")
    public SocketSensorDataResponse SocketHandler(){
        Long ssId = 1L;
        Long inputData = 2L;
        SocketSensorDataResponse socketSensorDataResponse = new SocketSensorDataResponse(ssId, inputData);
        return socketSensorDataResponse;
    }

}
