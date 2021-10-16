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
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long typeId;

    @Column(nullable = false, unique = true)
    private String typeName;

    @Column(nullable = true)
    private String typeDtl;

    @Column(nullable = false, unique = true)
    private String typeCode;

    @Column(nullable = false, unique = true)
    private String typeColorCode;

    @Column
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }



}