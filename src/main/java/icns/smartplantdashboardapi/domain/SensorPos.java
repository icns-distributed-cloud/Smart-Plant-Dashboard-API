package icns.smartplantdashboardapi.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SensorPos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long posId;

    @Column
    private String PosName;

    @Column
    private String PosDtl;


}
