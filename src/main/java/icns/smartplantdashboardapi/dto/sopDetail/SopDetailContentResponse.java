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
    private String posName;
    private boolean message;
    private String messageContent;


    public SopDetailContentResponse(SopDetailContent sopDetailContent){
        this.id = sopDetailContent.getId();
        this.titleId = sopDetailContent.getSopDetail().getId();
        this.text = sopDetailContent.getText();
        this.complete = sopDetailContent.isComplete();
        this.message = sopDetailContent.isMessage();
        if(sopDetailContent.isMessage()){
            this.posId = sopDetailContent.getSsPos().getPosId();
            this.posName = sopDetailContent.getSsPos().getPosName();
            this.messageContent = sopDetailContent.getMessageContent();
        }else{
            this.posId = null;
            this.posName = null;
            this.messageContent = null;
        }

    }
}
