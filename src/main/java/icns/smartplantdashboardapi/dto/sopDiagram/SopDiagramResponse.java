package icns.smartplantdashboardapi.dto.sopDiagram;

import icns.smartplantdashboardapi.domain.SopDiagram;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SopDiagramResponse {
    private Long id;
    private Long situationId;
    private String situationName;
    private Integer level;
    private String diagram;
    private String diagramImgPath;


    public SopDiagramResponse(SopDiagram sopDiagram, String diagram, String diagramImgPath){
        this.id = sopDiagram.getId();
        this.situationId = sopDiagram.getSituation().getId();
        this.situationName = sopDiagram.getSituation().getName();
        this.level = sopDiagram.getLevel();
        this.diagram = diagram;
        this.diagramImgPath = diagramImgPath;
    }

}