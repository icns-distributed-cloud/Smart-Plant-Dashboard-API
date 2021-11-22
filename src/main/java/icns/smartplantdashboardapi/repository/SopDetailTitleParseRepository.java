package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.domain.SopDetailTitleParse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SopDetailTitleParseRepository extends JpaRepository<SopDetailTitleParse, Long> {
    List<SopDetailTitleParse> deleteBySsTypeAndLevel(SensorType sensorType, Integer level);
    List<SopDetailTitleParse> findBySsTypeAndLevel(SensorType sensorType, Integer level);

}
