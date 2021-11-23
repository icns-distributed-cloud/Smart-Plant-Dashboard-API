package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.Situation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituationRepository extends JpaRepository<Situation, Long> {

}
