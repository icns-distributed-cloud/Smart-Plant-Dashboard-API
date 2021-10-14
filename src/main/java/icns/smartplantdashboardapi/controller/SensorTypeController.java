package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.service.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorTypeController {
    private final SensorTypeService sensorTypeService;

}
