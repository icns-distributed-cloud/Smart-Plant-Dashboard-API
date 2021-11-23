package icns.smartplantdashboardapi.dto.CCTV;

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
    private String cctvLocation;

    public CCTVResponse(CCTV cctv){
        this.cctvId = cctv.getCctvId();
        this.userId = cctv.getUserId();
        this.password = cctv.getPassword();
        this.streamURL = cctv.getStreamURL();
        this.websocketURL = cctv.getWebsocketURL();
        this.cctvLocation = cctv.getCctvLocation();
    }

}
