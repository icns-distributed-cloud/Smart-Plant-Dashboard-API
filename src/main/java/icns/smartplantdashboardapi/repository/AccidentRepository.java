package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
