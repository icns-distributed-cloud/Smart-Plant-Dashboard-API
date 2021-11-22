package icns.smartplantdashboardapi.dto.sopDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SopDetailTitleParseResponse {
    List<String> titleParseList = new ArrayList<>();

    public SopDetailTitleParseResponse(List<String> titleList){
        titleParseList = titleList;
    }
}
