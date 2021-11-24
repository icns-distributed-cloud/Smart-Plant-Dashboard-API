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
    private String backgroundImgPath;

    private String position;

    private String positionImgPath;

    public SensorPosResponse(SensorPos sensorPos, String position){
        this.posId = sensorPos.getPosId();
        this.posName = sensorPos.getPosName();
        this.posDtl = sensorPos.getPosDtl();
        this.posCode = sensorPos.getPosCode();
        this.backgroundImgPath = sensorPos.getBackgroundImgPath();
        this.positionImgPath = sensorPos.getPositionImgPath();
        this.position = position;
    }

    public SensorPosResponse(SensorPos sensorPos){
        this.posId = sensorPos.getPosId();
        this.posName = sensorPos.getPosName();
        this.posDtl = sensorPos.getPosDtl();
        this.posCode = sensorPos.getPosCode();
        this.backgroundImgPath = sensorPos.getBackgroundImgPath();
        this.positionImgPath = sensorPos.getPositionImgPath();
        this.position = sensorPos.getPositionPath();
    }

}
