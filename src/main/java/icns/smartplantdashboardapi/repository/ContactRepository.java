package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
