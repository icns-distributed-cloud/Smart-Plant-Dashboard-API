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

    @ManyToOne(targetEntity = SensorType.class, fetch=FetchType.LAZY)
    @JoinColumn(name="sensortype_id")
    private SensorType ssType;

    @Column
    private Integer level;

    @Column
    private String title;
}