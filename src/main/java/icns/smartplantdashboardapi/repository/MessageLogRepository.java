package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
