package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SopDetailRequest {
    private Long situationId;

    private Integer level;

    private String title;

    public SopDetail toEntity(Situation situation){
        return SopDetail.builder()
                .situation(situation)
                .level(level)
                .title(title)
                .build();
    }
}
