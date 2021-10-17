package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
    Optional<SensorType> findByTypeName(String typeName);

    Optional<SensorType> findByTypeCode(String typeCode);

}
