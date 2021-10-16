package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorPos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorPosRepository extends JpaRepository<SensorPos, Long> {

    Optional<SensorPos> findByPosName(String posName);

    Optional<SensorPos> findByPosCode(String posCode);
}
