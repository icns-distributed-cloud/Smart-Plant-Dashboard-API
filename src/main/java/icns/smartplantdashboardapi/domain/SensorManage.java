package icns.smartplantdashboardapi.domain;

import icns.smartplantdashboardapi.dto.sensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.sensorManage.range.SensorRangeRequest;
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

    // SensorRange
    @Column
    private float rstart;

    @Column
    private float rlev1;

    @Column
    private float rlev2;

    @Column
    private float rlev3;

    @Column
    private float rlev4;

    @Column
    private float rend;

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
        this.ssDtl = sensorManageRequest.getSsDtl();
        this.ssContact = sensorManageRequest.getSsContact();
        this.ssContactExt = sensorManageRequest.getSsContactExt();
        this.ssContactPhone = sensorManageRequest.getSsContactPhone();
        return this;
    }

    public SensorManage updateRange(SensorRangeRequest sensorRangeRequest){
        this.rstart = sensorRangeRequest.getRstart();
        this.rlev1 = sensorRangeRequest.getRlev1();
        this.rlev2 = sensorRangeRequest.getRlev2();
        this.rlev3 = sensorRangeRequest.getRlev3();
        this.rlev4 = sensorRangeRequest.getRlev4();
        this.rend = sensorRangeRequest.getRend();
        return this;
    }


}
