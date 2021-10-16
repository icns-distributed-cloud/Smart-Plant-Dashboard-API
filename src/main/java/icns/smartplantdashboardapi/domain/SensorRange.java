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
public class SensorRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long rangeId;

    @OneToOne(mappedBy = "sensorRange")
    private SensorManage sensorManage;

    @Column
    private int start;

    @Column
    private int lev1;

    @Column
    private int lev2;

    @Column
    private int lev3;

    @Column
    private int lev4;

    @Column
    private int end;



}
