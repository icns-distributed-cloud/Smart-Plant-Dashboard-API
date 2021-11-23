package icns.smartplantdashboardapi.dto.sop;


import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.Sop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SopRequest {
    private Long situationId;
    private Integer level;
    private String diagram;

    public Sop toEntity(Situation situation, String diagramPath){
        return Sop.builder()
                .situation(situation)
                .level(level)
                .diagramPath(diagramPath)
                .build();
    }
}

