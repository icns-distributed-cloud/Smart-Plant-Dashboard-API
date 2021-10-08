package icns.smartplantdashboardapi.domain;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long sensorTypeId;

    @Column
    private String sensorTypeName;

    @Column
    private String sensorTypeEtc;
}
