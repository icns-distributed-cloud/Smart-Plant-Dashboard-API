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
public class SopDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Situation.class, fetch=FetchType.LAZY)
    @JoinColumn(name="situation_id")
    private Situation situation;

    @Column
    private Long nodeId;

    @Column
    private Integer level;

    @Column
    private String title;

    @Column
    private float y;

    public void update(String title, float y){
        this.title=title;
        this.y = y;
    }


}
