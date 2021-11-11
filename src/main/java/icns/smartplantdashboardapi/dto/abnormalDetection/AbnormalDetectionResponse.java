package icns.smartplantdashboardapi.dto.abnormalDetection;

import icns.smartplantdashboardapi.domain.AbnormalDetection;
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
    private String state;

    @NotEmpty
    private Long posId;

    @NotEmpty
    private String ssCode;


    public AbnormalDetectionResponse(AbnormalDetection abnormalDetection){
        this.createdAt = abnormalDetection.getCreatedAt();
        this.state = abnormalDetection.getState();
        this.posId = abnormalDetection.getSensorManage().getSsPos().getPosId();
        this.ssCode = abnormalDetection.getSensorManage().createSensorCode();
    }


}
