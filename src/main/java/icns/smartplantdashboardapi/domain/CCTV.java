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
public class CCTV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long cctvId;

    @ManyToOne(targetEntity = SensorPos.class, fetch=FetchType.LAZY)
    @JoinColumn(name="sensorpos_id", nullable = false)
    private SensorPos ssPos;

    @Column(nullable = true)
    private String userId;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String streamURL;

    @Column(nullable = true)
    private String websocketURL;

    @Column(nullable = true)
    private String cctvLocation;



}
