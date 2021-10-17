package icns.smartplantdashboardapi.domain;

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
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long dataId;

    @ManyToOne(targetEntity = SensorManage.class)
    @JoinColumn(name = "sensormanage_id")
    private SensorManage sensorManage;

    @Column
    private float inputData;

    @Column
    private LocalDateTime createdAt;


    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "dataId=" + dataId +
                ", sensorManage=" + sensorManage +
                ", inputData=" + inputData +
                ", createdAt=" + createdAt +
                '}';
    }
}
