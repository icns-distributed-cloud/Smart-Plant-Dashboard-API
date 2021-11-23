package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
import icns.smartplantdashboardapi.domain.AbnormalDetection;
import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.dto.abnormalDetection.AbnormalDetectionRequest;
import icns.smartplantdashboardapi.dto.abnormalDetection.socket.SocketAbnormalDetectionResponse;
import icns.smartplantdashboardapi.repository.AbnormalDetectionRepository;
import icns.smartplantdashboardapi.repository.SensorManageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AbnormalDetectionService {

    private final AbnormalDetectionRepository abnormalDetectionRepository;
    private final SensorManageRepository sensorManageRepository;

    @Transactional
    public Long save(AbnormalDetectionRequest abnormalDetectionRequest){
        SensorManage sensorManage = sensorManageRepository.findById(abnormalDetectionRequest.getSensorManageId()).orElseThrow(SensorManageNotFoundException::new);
        AbnormalDetection saved =abnormalDetectionRepository.save(abnormalDetectionRequest.toEntity(sensorManage));
        return saved.getId();
    }

    @Transactional(readOnly = true)
    public Page<SocketAbnormalDetectionResponse> find(Long posId, Pageable pageable){
        Page<SocketAbnormalDetectionResponse> abnormalDetectionList;

        if(posId == null){
            abnormalDetectionList = abnormalDetectionRepository.findAll(pageable).map(SocketAbnormalDetectionResponse::new);
        }else{
            abnormalDetectionList = abnormalDetectionRepository.findBySensorManage_SsPos_PosId(posId, pageable).map(SocketAbnormalDetectionResponse::new);
        }
        return abnormalDetectionList;
    }
}
