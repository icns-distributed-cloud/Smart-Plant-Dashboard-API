package icns.smartplantdashboardapi.dto.sop;

import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Sop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SopRequest {
    private Long typeId;
    private Integer level;

    public Sop toEntity(SensorType sensorType, String diagramPath){
        return Sop.builder()
                .ssType(sensorType)
                .level(level)
                .diagramPath(diagramPath)
                .build();
    }
}

