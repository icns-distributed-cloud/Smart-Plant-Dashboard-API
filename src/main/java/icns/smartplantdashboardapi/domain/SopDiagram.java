package icns.smartplantdashboardapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SopDiagram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(targetEntity = Situation.class, fetch=FetchType.LAZY)
    @JoinColumn(name="situation_id")
    private Situation situation;

    @Column
    private Integer level;

    @Column
    private String diagramPath;

    public SopDiagram update(String diagramPath){
        this.diagramPath = diagramPath;
        return this;
    }

}


