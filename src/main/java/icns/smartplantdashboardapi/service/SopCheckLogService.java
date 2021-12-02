package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.SopCheckLog;
import icns.smartplantdashboardapi.dto.sensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.repository.SopCheckLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SopCheckLogService {
    private final SopCheckLogRepository sopCheckLogRepository;

    @Transactional(readOnly = true)
    public Page<SopCheckLog> findAll(Pageable pageable) {
        Page<SopCheckLog> sopCheckLogList = sopCheckLogRepository.findAll(pageable);
        return sopCheckLogList;
    }

}