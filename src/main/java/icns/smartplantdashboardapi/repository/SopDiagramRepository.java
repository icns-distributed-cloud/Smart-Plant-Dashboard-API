package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDiagram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SopDiagramRepository extends JpaRepository<SopDiagram, Long> {
    Optional<SopDiagram> findBySituationAndLevel(Situation situation, Integer level);
    Optional<SopDiagram> deleteBySituationAndLevel(Situation situation, Integer level);


}
