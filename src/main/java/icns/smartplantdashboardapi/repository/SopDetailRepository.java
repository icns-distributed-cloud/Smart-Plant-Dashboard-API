package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.domain.SopDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SopDetailRepository extends JpaRepository<SopDetail, Long> {
    List<SopDetail> findBySituationAndLevel(Situation situation, Integer level);
}
