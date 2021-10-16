package icns.smartplantdashboardapi.dto.sensorPos;

import icns.smartplantdashboardapi.domain.SensorPos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorPosResponse {
    private Long posId;
    private String posName;
    private String posDtl;
    private String posCode;

    public SensorPosResponse(SensorPos sensorPos){
        this.posId = sensorPos.getPosId();
        this.posName = sensorPos.getPosName();
        this.posDtl = sensorPos.getPosDtl();
        this.posCode = sensorPos.getPosCode();
    }

}
