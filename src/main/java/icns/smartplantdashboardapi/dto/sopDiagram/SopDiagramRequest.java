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
    private String diagramImgPath;

    public SopDiagram toEntity(Situation situation, String diagramPath, String diagramImgPath){
        return SopDiagram.builder()
                .situation(situation)
                .level(level)
                .diagramPath(diagramPath)
                .diagramImgPath(diagramImgPath)
                .build();
    }
}

