package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SopDetailContent;
import icns.smartplantdashboardapi.domain.SopDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SopDetailContentRequest {
    private Long titleId;
    private String text;
    private boolean message;
    private Long posId;

    public SopDetailContent toEntity(SopDetail sopDetail, SensorPos sensorPos){

        return SopDetailContent.builder()
                .sopDetail(sopDetail)
                .text(text)
                .complete(false)
                .message(message)
                .ssPos(sensorPos)
                .build();

    }


}
