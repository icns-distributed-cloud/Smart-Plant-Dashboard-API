package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.domain.SopDetailTitleParse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SopDetailRepository extends JpaRepository<SopDetail, Long> {
    List<SopDetail> findBySituationAndLevel(Situation situation, Integer level);
    Optional<SopDetail> findByNodeId(Long nodeId);
    Optional<SopDetail> deleteByNodeId(Long nodeId);
    List<SopDetail> findBySituationAndLevelOrderByY(Situation situation, Integer level);


}
