package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findAllByOrderByCreatedAtDesc();
}
