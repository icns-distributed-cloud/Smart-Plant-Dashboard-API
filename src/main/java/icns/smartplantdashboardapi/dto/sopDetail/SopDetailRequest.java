package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.SopDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SopDetailRequest {
    private Long typeId;

    private Integer level;

    private String title;

    public SopDetail toEntity(SensorType sensorType){
        return SopDetail.builder()
                .ssType(sensorType)
                .level(level)
                .title(title)
                .build();
    }
}
