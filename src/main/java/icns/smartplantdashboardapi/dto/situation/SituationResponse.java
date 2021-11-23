package icns.smartplantdashboardapi.dto.situation;

import icns.smartplantdashboardapi.domain.Situation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SituationResponse {
    private Long id;
    private String name;

    public SituationResponse(Situation situation){
        this.id = situation.getId();
        this.name = situation.getName();
    }
}
