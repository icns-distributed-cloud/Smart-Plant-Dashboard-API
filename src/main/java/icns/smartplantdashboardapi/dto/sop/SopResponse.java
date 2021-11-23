package icns.smartplantdashboardapi.dto.sop;

import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeResponse;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SopResponse {
    private Long id;
    private Long situationId;
    private String situationName;
    private Integer level;
    private String diagram;


    public SopResponse(Sop sop, String diagram){
        this.id = sop.getId();
        this.situationId = sop.getSituation().getId();
        this.situationName = sop.getSituation().getName();
        this.level = sop.getLevel();
        this.diagram = diagram;
    }

}