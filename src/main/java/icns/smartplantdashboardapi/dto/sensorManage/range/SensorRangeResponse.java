package icns.smartplantdashboardapi.dto.sensorManage.range;

import icns.smartplantdashboardapi.domain.SensorManage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorRangeResponse {
    private Long ssId;

    private float rstart;

    private float rlev1;

    private float rlev2;

    private float rlev3;

    private float rlev4;

    private float rend;

    private String sensorTypeName;

    private String ssCode;

    private Long sensorPosId;

    public SensorRangeResponse(SensorManage sensorManage){
        this.ssId = sensorManage.getSsId();
        this.rstart= sensorManage.getRstart();
        this.rlev1 = sensorManage.getRlev1();
        this.rlev2 = sensorManage.getRlev2();
        this.rlev3 = sensorManage.getRlev3();
        this.rlev4 = sensorManage.getRlev4();
        this.rend = sensorManage.getRend();
        this.ssCode = sensorManage.createSensorCode();
        this.sensorPosId = sensorManage.getSsPos().getPosId();
        this.sensorTypeName = sensorManage.getSsType().getTypeName();
    }

}
