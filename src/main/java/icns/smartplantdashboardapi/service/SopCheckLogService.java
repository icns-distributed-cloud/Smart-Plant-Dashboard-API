package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.SopCheckLog;
import icns.smartplantdashboardapi.repository.SopCheckLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SopCheckLogService {
    private final SopCheckLogRepository sopCheckLogRepository;

    @Transactional(readOnly = true)
    public List<SopCheckLog> findAll(){
        List<SopCheckLog> sopCheckLogList = sopCheckLogRepository.findAll();
        return sopCheckLogList;
    }


}
