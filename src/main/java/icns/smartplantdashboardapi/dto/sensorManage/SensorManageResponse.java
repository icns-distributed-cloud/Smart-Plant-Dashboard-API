package icns.smartplantdashboardapi.dto.sensorManage;

import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorManageResponse {
    private Long ssId;
    private SensorPosResponse ssPos;
    private SensorTypeResponse ssType;
    private String ssName;
    private String ssDtl;
    private String ssContact;
    private String ssContactExt;
    private String ssContactPhone;
    private String ssCode;

    public SensorManageResponse(SensorManage sensorManage){
        this.ssId = sensorManage.getSsId();
        this.ssName= sensorManage.getSsName();
        this.ssDtl = sensorManage.getSsDtl();
        this.ssContact = sensorManage.getSsContact();
        this.ssContactExt = sensorManage.getSsContactExt();
        this.ssCode = sensorManage.getSsCode();
        this.ssContactPhone = sensorManage.getSsContactPhone();
        this.ssPos = new SensorPosResponse(sensorManage.getSsPos());
        this.ssType = new SensorTypeResponse(sensorManage.getSsType());
   }

}
