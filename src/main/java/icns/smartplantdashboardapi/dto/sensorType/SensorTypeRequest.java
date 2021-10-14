package icns.smartplantdashboardapi.dto.sensorType;

import icns.smartplantdashboardapi.domain.SensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorTypeRequest {
    private String typeName;
    private String typeDtl;


    public SensorType toEntity(){
        return SensorType.builder()
                .typeName(typeName)
                .typeDtl(typeDtl)
                .build();
    }
}
