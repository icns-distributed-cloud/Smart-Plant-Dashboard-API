package icns.smartplantdashboardapi.dto.sensorManage;

import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorManageSimpleResponse {
    private Long ssId;
    private Long posId;
    private Long typeId;
    private String ssCode;

    public SensorManageSimpleResponse(SensorManage sensorManage){
        this.ssId = sensorManage.getSsId();
        this.ssCode = sensorManage.getSsCode();
        this.posId = sensorManage.getSsPos().getPosId();
        this.typeId =sensorManage.getSsType().getTypeId();
    }

    @Override
    public String toString() {
        return "SensorManageSimpleResponse{" +
                "ssId=" + ssId +
                ", posId=" + posId +
                ", typeId=" + typeId +
                ", ssCode='" + ssCode + '\'' +
                '}';
    }
}
