package icns.smartplantdashboardapi.repository;

import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorManageRepository extends JpaRepository<SensorManage, Long> {
    Page<SensorManage> findBySsPos_PosId(@Param(value="posId") Long posId, Pageable pageable);

    Page<SensorManage> findBySsType_TypeId(@Param(value="typeId") Long typeId, Pageable pageable);

}
