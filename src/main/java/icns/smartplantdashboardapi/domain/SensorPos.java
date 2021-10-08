package icns.smartplantdashboardapi.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SensorPos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String SsPosName;




}
