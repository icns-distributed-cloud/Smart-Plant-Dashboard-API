package icns.smartplantdashboardapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SopDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(targetEntity = Sop.class, fetch= FetchType.LAZY)
    @JoinColumn(name="sop_id")
    private Sop sop;

    @ElementCollection
    @CollectionTable(name = "diagram_title_list")
    private List<String> diagramTitleList;

}
