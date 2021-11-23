package icns.smartplantdashboardapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SopDetailTitleParse {
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
    private float y;

    @Column
    private String title;
}
