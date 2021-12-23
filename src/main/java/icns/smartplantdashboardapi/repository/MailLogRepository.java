package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.MailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailLogRepository extends JpaRepository<MailLog, Long> {
}
