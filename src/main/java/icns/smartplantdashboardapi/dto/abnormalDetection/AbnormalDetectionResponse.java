package icns.smartplantdashboardapi.dto.abnormalDetection;

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
public class AbnormalDetectionResponse {
    @NotEmpty
    private LocalDateTime createdAt;

    @NotEmpty
    private Integer sensorState;

    @NotEmpty
    private Long posId;

    @NotEmpty
    private String ssCode;


    public AbnormalDetectionResponse(AbnormalDetection abnormalDetection){
        this.createdAt = abnormalDetection.getCreatedAt();
        this.sensorState = abnormalDetection.getSensorState();
        this.posId = abnormalDetection.getSensorManage().getSsPos().getPosId();
        this.ssCode = abnormalDetection.getSensorManage().createSensorCode();
    }


}