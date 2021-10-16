package icns.smartplantdashboardapi.dto.sensorType;

import icns.smartplantdashboardapi.domain.SensorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorTypeResponse {
    private Long typeId;
    private String typeName;
    private String typeDtl;
    private String typeCode;
    private String typeColorCode;

    public SensorTypeResponse(SensorType sensorType){
        this.typeId = sensorType.getTypeId();
        this.typeName = sensorType.getTypeName();
        this.typeDtl = sensorType.getTypeDtl();
        this.typeCode = sensorType.getTypeCode();
        this.typeColorCode = sensorType.getTypeColorCode();
    }
}