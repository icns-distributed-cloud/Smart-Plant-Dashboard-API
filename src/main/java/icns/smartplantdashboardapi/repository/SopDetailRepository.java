package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SopDetailRepository extends JpaRepository<SopDetail, Long> {
    List<SopDetail> findBySituationAndLevel(Situation situation, Integer level);
}
