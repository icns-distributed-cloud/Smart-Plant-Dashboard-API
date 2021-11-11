package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.AbnormalDetection;
import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbnormalDetectionRepository extends JpaRepository<AbnormalDetection, Long>{
    Page<AbnormalDetection> findBySensorManage_SsPos_PosId(@Param(value="posId") Long posId, Pageable pageable);

}
