package icns.smartplantdashboardapi.dto.sopDetail;

import icns.smartplantdashboardapi.domain.SopDetailTitleParse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SopDetailTitleParseResponse {
    @Column
    private float y;

    @Column
    private String title;

    public SopDetailTitleParseResponse(SopDetailTitleParse sopDetailTitleParse){

        y = sopDetailTitleParse.getY();
        title = sopDetailTitleParse.getTitle();
    }
}
