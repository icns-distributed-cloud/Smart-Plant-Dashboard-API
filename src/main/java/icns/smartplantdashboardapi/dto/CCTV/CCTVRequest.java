package icns.smartplantdashboardapi.dto.CCTV;


import icns.smartplantdashboardapi.domain.CCTV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CCTVRequest {

    private String userId;

    private String password;

    private String streamURL;

    private String cctvLocation;

    private String websocketURL;



    public CCTV toEntity(){
        return CCTV.builder()
                .userId(userId)
                .password(password)
                .cctvLocation(cctvLocation)
                .streamURL(streamURL)
                .websocketURL(websocketURL)
                .build();
    }

}
