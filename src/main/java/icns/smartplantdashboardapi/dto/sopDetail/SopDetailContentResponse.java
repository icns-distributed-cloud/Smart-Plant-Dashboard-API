package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.SopDetailContent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SopDetailContentResponse {
    private Long id;
    private Long titleId;
    private String text;
    private boolean complete;
    private Long posId;
    private boolean message;

    public SopDetailContentResponse(SopDetailContent sopDetailContent){
        this.id = sopDetailContent.getId();
        this.titleId = sopDetailContent.getSopDetail().getId();
        this.text = sopDetailContent.getText();
        this.complete = sopDetailContent.isComplete();
        this.message = sopDetailContent.isMessage();
        this.posId = sopDetailContent.getSsPos().getPosId();
    }
}
