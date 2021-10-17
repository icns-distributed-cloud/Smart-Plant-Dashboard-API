package icns.smartplantdashboardapi.dto.sensorManage.range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SensorRangeRequest {

    private float rstart;

    private float rlev1;

    private float rlev2;

    private float rlev3;

    private float rlev4;

    private float rend;


}
