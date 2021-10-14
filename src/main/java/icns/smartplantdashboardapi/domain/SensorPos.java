package icns.smartplantdashboardapi.domain;

import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorPos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long posId;

    @Column(nullable = false, unique = true)
    private String posName;

    @Column(nullable = true)
    private String posDtl;

    @Column
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }
    public SensorPos update(SensorPosRequest sensorPosRequest){
        this.posName = sensorPosRequest.getPosName();
        this.posDtl = sensorPosRequest.getPosDtl();
        return this;
    }

}
