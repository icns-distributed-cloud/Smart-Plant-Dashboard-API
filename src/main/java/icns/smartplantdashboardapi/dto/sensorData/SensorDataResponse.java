package icns.smartplantdashboardapi.dto.sensorData;

import icns.smartplantdashboardapi.domain.EState;
import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.dto.sensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.dto.sensorManage.SensorManageSimpleResponse;
import icns.smartplantdashboardapi.dto.sensorManage.range.SensorRangeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataResponse {
    private Long dataId;

    private float inputData;

    private LocalDateTime createdAt;

    private SensorManageResponse sensorManage;

    private Integer sensorState;

    public SensorDataResponse(SensorData sensorData){
        this.dataId = sensorData.getDataId();
        this.sensorManage = new SensorManageResponse(sensorData.getSensorManage());
        this.inputData = sensorData.getInputData();
        this.createdAt = sensorData.getCreatedAt();

        if(this.inputData > sensorData.getSensorManage().getRlev4()){
            this.sensorState = EState.SERIOUS.ordinal();
        }else if(this.inputData > sensorData.getSensorManage().getRlev3()){
            this.sensorState = EState.WANRNING.ordinal();
        }else if(this.inputData > sensorData.getSensorManage().getRlev2()){
            this.sensorState = EState.CAUTION.ordinal();
        }else if(this.inputData > sensorData.getSensorManage().getRlev1()) {
            this.sensorState = EState.ATTENTION.ordinal();
        }else{
            this.sensorState = EState.SAFE.ordinal();
        }

    }


}
