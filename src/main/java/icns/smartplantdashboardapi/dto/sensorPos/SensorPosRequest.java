package icns.smartplantdashboardapi.dto.sensorPos;

import icns.smartplantdashboardapi.domain.SensorPos;
import lombok.*;
import org.springframework.security.core.userdetails.User;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorPosRequest {
    private String posName;
    private String posDtl;
    private String posCode;

    public SensorPos toEntity(){
        return SensorPos.builder()
                .posName(posName)
                .posDtl(posDtl)
                .posCode(posCode)
                .build();
    }

}
