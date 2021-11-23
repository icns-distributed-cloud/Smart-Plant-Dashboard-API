package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.CCTV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CCTVRepository extends JpaRepository<CCTV, Long> {

}
