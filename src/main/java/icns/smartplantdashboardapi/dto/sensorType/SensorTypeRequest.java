package icns.smartplantdashboardapi.dto.sensorType;

import icns.smartplantdashboardapi.domain.SensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SensorTypeRequest {
    @NotEmpty
    private String typeName;

    private String typeDtl;

    @NotEmpty
    private String typeCode;

    @NotEmpty
    private String typeColorCode;

    private String unit;

    private Integer display;

    public SensorType toEntity(){
        return SensorType.builder()
                .typeName(typeName)
                .typeDtl(typeDtl)
                .typeCode(typeCode)
                .typeColorCode(typeColorCode)
                .display(display)
                .unit(unit)
                .build();
    }
}
