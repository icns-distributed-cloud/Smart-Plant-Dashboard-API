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
    private Long typeId;
    private String typeName;
    private Integer level;
    private String diagramPath;


    public SopResponse(Sop sop){
        this.id = sop.getId();
        this.typeId = sop.getSsType().getTypeId();
        this.typeName = sop.getSsType().getTypeName();
        this.level = sop.getLevel();
        this.diagramPath = sop.getDiagramPath();
    }

}