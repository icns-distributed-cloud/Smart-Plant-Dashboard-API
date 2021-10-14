package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
}
