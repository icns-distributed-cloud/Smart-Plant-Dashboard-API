package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.Sop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SopRepository extends JpaRepository<Sop, Long> {
    Optional<Sop> findBySituationAndLevel(Situation situation, Integer level);

}
