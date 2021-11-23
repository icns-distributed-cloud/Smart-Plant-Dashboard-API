package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SopDetailContent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SopDetailContentRepository extends JpaRepository<SopDetailContent, Long> {
    List<SopDetailContent> findBySopDetail_Id(@Param(value="titleId") Long titleId);

}
