package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findBySensorManage_SsPosOrderByCreatedAtDesc(@Param(value="ssPos")SensorPos ssPos);
    SensorData findTop1BySensorManageOrderByCreatedAtDesc(@Param(value="sensorManage") SensorManage sensorManage);
    List<SensorData> deleteByCreatedAtLessThan(LocalDateTime threshold);
}
