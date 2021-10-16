package icns.smartplantdashboardapi.domain;

import icns.smartplantdashboardapi.dto.SensorManage.SensorManageRequest;
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
public class SensorManage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long ssId;

    @ManyToOne(targetEntity = SensorType.class, fetch=FetchType.LAZY)
    @JoinColumn(name="sensortype_id")
    private SensorType ssType;

    @ManyToOne(targetEntity = SensorPos.class, fetch=FetchType.LAZY)
    @JoinColumn(name="sensorpos_id", nullable = false)
    private SensorPos ssPos;

    @Column
    private String ssName;

    @Column
    private String ssCode;

    @Column
    private String ssDtl;

    @Column
    private String ssContact;

    @Column
    private String ssContactExt;

    @Column
    private String ssContactPhone;

    @Column
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }


    public void createSensorCode(){
        this.ssCode = ssPos.getPosCode() + "-"+ssType.getTypeCode()+"-"+ssId;
    }
    public SensorManage update(SensorManageRequest sensorManageRequest, SensorPos ssPos, SensorType ssType){
        this.ssPos = ssPos;
        this.ssType = ssType;
        this.ssName = sensorManageRequest.getSsName();
        this.ssDtl = sensorManageRequest.getSsDtl();
        this.ssContact = sensorManageRequest.getSsContact();
        this.ssContactExt = sensorManageRequest.getSsContactExt();
        this.ssContactPhone = sensorManageRequest.getSsContactPhone();
        return this;
    }

}
