package icns.smartplantdashboardapi.domain;

import icns.smartplantdashboardapi.dto.sensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.sensorManage.range.SensorRangeRequest;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    private String ssContact;

    @Column
    private String ssContactExt;

    @Column
    private String ssContactPhone;

    // SensorState
    @Column
    private Integer sensorState;

    // SensorRange
    @ColumnDefault("0")
    private float rstart;

    @ColumnDefault("20")
    private float rlev1;

    @ColumnDefault("40")
    private float rlev2;

    @ColumnDefault("60")
    private float rlev3;

    @ColumnDefault("80")
    private float rlev4;

    @ColumnDefault("100")
    private float rend;

    public String createSensorCode(){
        return ssPos.getPosCode() + "-"+ssType.getTypeCode()+"-"+ssId;
    }


    public SensorManage update(SensorManageRequest sensorManageRequest, SensorPos ssPos, SensorType ssType){
        this.ssPos = ssPos;
        this.ssType = ssType;
        this.ssContact = sensorManageRequest.getSsContact();
        this.ssContactExt = sensorManageRequest.getSsContactExt();
        this.ssContactPhone = sensorManageRequest.getSsContactPhone();
        return this;
    }

    public Integer setSensorState(float data){
        if(data > this.rlev4){
            this.sensorState = EState.SERIOUS.ordinal();
       }else if(data > this.rlev3){
            this.sensorState = EState.WANRNING.ordinal();
        }else if(data > this.rlev2){
            this.sensorState = EState.CAUTION.ordinal();
        }else if(data > this.rlev1) {
            this.sensorState = EState.ATTENTION.ordinal();
        }else{
            this.sensorState = EState.SAFE.ordinal();
        }
        return this.sensorState;
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
