package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.domain.SopDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SopDetailResponse {
    private Long id;

    private Long typeId;

    private Integer level;

    private String title;

    public SopDetailResponse(SopDetail sopDetail){
        this.id = sopDetail.getId();
        this.typeId = sopDetail.getSsType().getTypeId();
        this.level = sopDetail.getLevel();
        this.title = sopDetail.getTitle();
    }
}
