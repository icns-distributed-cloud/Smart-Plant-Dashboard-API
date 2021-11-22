package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.SopDetailCheck;
import icns.smartplantdashboardapi.domain.SopDetail;

public class SopDetailCheckRequest {
    private Long titleId;
    private String text;

    public SopDetailCheck toEntity(SopDetail sopDetail){

        return SopDetailCheck.builder()
                .sopDetail(sopDetail)
                .text(text)
                .build();

    }


}
