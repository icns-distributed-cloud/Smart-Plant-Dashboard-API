package icns.smartplantdashboardapi.dto.abnormalDetection.socket;

import icns.smartplantdashboardapi.domain.AbnormalDetection;
import icns.smartplantdashboardapi.domain.EState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SocketAbnormalDetectionResponse {
    private LocalDateTime createdAt;

    private Integer sensorState;

    private Long posId;

    private String ssCode;

    private String posName;

    private String typeName;


    public SocketAbnormalDetectionResponse(AbnormalDetection abnormalDetection){
        this.createdAt = abnormalDetection.getCreatedAt();
        this.sensorState = abnormalDetection.getSensorState();
        this.posId = abnormalDetection.getSensorManage().getSsPos().getPosId();
        this.ssCode = abnormalDetection.getSensorManage().createSensorCode();
        this.posName = abnormalDetection.getSensorManage().getSsPos().getPosName();
        this.typeName = abnormalDetection.getSensorManage().getSsType().getTypeName();
    }


}
