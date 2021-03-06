package icns.smartplantdashboardapi.dto.cctv;

import icns.smartplantdashboardapi.domain.CCTV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CCTVResponse {
    private Long cctvId;
    private String userId;
    private String password;
    private String streamURL;
    private String websocketURL;
    private Long posId;
    private String posName;
    private String abnormalWebsocketUrl;

    public CCTVResponse(CCTV cctv){
        this.cctvId = cctv.getCctvId();
        this.userId = cctv.getUserId();
        this.password = cctv.getPassword();
        this.streamURL = cctv.getStreamURL();
        this.websocketURL = cctv.getWebsocketURL();
        this.posId = cctv.getSsPos().getPosId();
        this.posName = cctv.getSsPos().getPosName();
        this.abnormalWebsocketUrl = cctv.getAbnormalWebsocketUrl();
    }

}
