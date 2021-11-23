package icns.smartplantdashboardapi.dto.situation;

import icns.smartplantdashboardapi.domain.Situation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SituationRequest {

    private String name;

    public Situation toEntity(){
        return Situation.builder()
                .name(name)
                .build();
    }
}
