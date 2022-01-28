package icns.smartplantdashboardapi.dto.abnormalDetection;

import icns.smartplantdashboardapi.domain.AbnormalDetection;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbnormalDetectionResponse {
  private LocalDateTime createdAt;

  private Integer sensorState;

  private Long posId;

  private String ssCode;

  private String posName;

  private String typeName;

  private Long typeId;


  public AbnormalDetectionResponse(AbnormalDetection abnormalDetection){
    this.createdAt = abnormalDetection.getCreatedAt();
    this.sensorState = abnormalDetection.getSensorState();
    this.posId = abnormalDetection.getSensorManage().getSsPos().getPosId();
    this.ssCode = abnormalDetection.getSensorManage().createSensorCode();
    this.posName = abnormalDetection.getSensorManage().getSsPos().getPosName();
    this.typeName = abnormalDetection.getSensorManage().getSsType().getTypeName();
    this.typeId = abnormalDetection.getSensorManage().getSsType().getTypeId();
  }
}
