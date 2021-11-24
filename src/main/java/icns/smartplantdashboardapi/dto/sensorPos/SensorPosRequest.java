package icns.smartplantdashboardapi.dto.sensorPos;

import icns.smartplantdashboardapi.domain.SensorPos;
import lombok.*;
import org.springframework.security.core.userdetails.User;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorPosRequest {

    @NotEmpty
    private String posName;

    private String posDtl;

    private String posCode;



}
