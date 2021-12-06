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
    private Integer function;
    private String info;


    public SopDetailContentResponse(SopDetailContent sopDetailContent){
        this.id = sopDetailContent.getId();
        this.titleId = sopDetailContent.getSopDetail().getId();
        this.text = sopDetailContent.getText();
        this.complete = sopDetailContent.isComplete();
        this.function = sopDetailContent.getEfunc();

        if(sopDetailContent.getEfunc()==1 || sopDetailContent.getEfunc() == 2){
            this.posId = sopDetailContent.getSsPos().getPosId();
            this.posName = sopDetailContent.getSsPos().getPosName();
            this.info = sopDetailContent.getInfo();

        }else if(sopDetailContent.getEfunc() == 0){
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
