package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SopDetailContent;
import icns.smartplantdashboardapi.domain.SopDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SopDetailContentRequest {
    private Long titleId;

    @NotEmpty
    private String text;
    private Integer function;
    private Long posId;
    private String info;

    public SopDetailContent toEntity(SopDetail sopDetail, SensorPos sensorPos){

        return SopDetailContent.builder()
                .sopDetail(sopDetail)
                .text(text)
                .complete(false)
                .efunc(function)
                .ssPos(sensorPos)
                .info(info)
                .build();

    }


}
