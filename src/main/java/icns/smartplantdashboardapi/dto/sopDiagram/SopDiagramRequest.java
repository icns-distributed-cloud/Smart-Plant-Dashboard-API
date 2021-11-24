package icns.smartplantdashboardapi.dto.sopDiagram;


import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDiagram;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SopDiagramRequest {
    private Long situationId;
    private Integer level;
    private String diagram;

    public SopDiagram toEntity(Situation situation, String diagramPath){
        return SopDiagram.builder()
                .situation(situation)
                .level(level)
                .diagramPath(diagramPath)
                .build();
    }
}

