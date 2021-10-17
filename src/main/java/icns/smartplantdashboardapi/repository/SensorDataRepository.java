package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.domain.SensorPos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findBySensorManage_SsPos(@Param(value="ssPos")SensorPos ssPos);

}
