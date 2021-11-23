package icns.smartplantdashboardapi.dto.sopDetail;

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
    private boolean complete;
    private boolean message;

    public SopDetailContent toEntity(SopDetail sopDetail){

        return SopDetailContent.builder()
                .sopDetail(sopDetail)
                .text(text)
                .complete(complete)
                .message(message)
                .build();

    }


}
