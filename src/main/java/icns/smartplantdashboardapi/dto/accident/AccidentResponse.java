package icns.smartplantdashboardapi.dto.accident;

import icns.smartplantdashboardapi.domain.Accident;
import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.sensorManage.SensorManageSimpleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccidentResponse {
    private Long id;

    private LocalDateTime createdAt;

    private String type;

    private Long posId;


    public AccidentResponse(Accident accident){
        this.id = accident.getId();
        this.createdAt = accident.getCreatedAt();
        this.type = accident.getType();
        this.posId = accident.getSsPos().getPosId();
    }
}
