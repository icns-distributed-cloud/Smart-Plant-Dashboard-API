package icns.smartplantdashboardapi.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SensorManage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long ssId;

    @ManyToOne(targetEntity = SensorPos.class, fetch=FetchType.LAZY)
    @JoinColumn(name="sensortype_id")
    private SensorType ssType;

    @ManyToOne(targetEntity = SensorType.class, fetch=FetchType.LAZY)
    @JoinColumn(name="sensorpos_id")
    private SensorPos ssPos;

    @Column
    private String ssDtl;

    @Column
    private String contact;

    @Column
    private String contactExt;

    @Column
    private String contactPhone;

}
