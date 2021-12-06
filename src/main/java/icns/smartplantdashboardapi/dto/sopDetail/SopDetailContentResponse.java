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
    private Integer efunction;
    private String info;


    public SopDetailContentResponse(SopDetailContent sopDetailContent){
        this.id = sopDetailContent.getId();
        this.titleId = sopDetailContent.getSopDetail().getId();
        this.text = sopDetailContent.getText();
        this.complete = sopDetailContent.isComplete();
        this.efunction = sopDetailContent.getEfunction();

        if(sopDetailContent.getEfunction()==1 || sopDetailContent.getEfunction() == 2){
            this.posId = sopDetailContent.getSsPos().getPosId();
            this.posName = sopDetailContent.getSsPos().getPosName();
            this.info = sopDetailContent.getInfo();

        }else if(sopDetailContent.getEfunction() == 0){
            this.posId = null;
            this.posName = null;
            this.info = null;
        }
        else{
            this.posId = null;
            this.posName = null;
            this.info = sopDetailContent.getInfo();
        }

    }
}
