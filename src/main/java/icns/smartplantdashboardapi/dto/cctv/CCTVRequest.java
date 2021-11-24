package icns.smartplantdashboardapi.dto.cctv;


import icns.smartplantdashboardapi.domain.CCTV;
import icns.smartplantdashboardapi.domain.SensorPos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CCTVRequest {

    private Long posId;

    private String userId;

    private String password;

    private String streamURL;

    private String websocketURL;



    public CCTV toEntity(SensorPos sensorPos){
        return CCTV.builder()
                .ssPos(sensorPos)
                .userId(userId)
                .password(password)
                .streamURL(streamURL)
                .websocketURL(websocketURL)
                .build();
    }

}
