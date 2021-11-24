package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SopMessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SopMessageLogRepository extends JpaRepository<SopMessageLog, Long> {
}
