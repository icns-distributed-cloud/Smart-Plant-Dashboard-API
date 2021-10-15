package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.repository.SensorManageRepository;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorManageService {

    private final SensorManageRepository sensorManageRepository;
    private final SensorPosRepository sensorPosRepository;

    @Transactional(readOnly = true)
    public Page<SensorManageResponse> findBySensorPosId(Long posId, Pageable pageable){
        Page<SensorManageResponse> sensorManageList = sensorManageRepository.findBySsPos_PosId(posId, pageable).map(SensorManageResponse::new);
        return sensorManageList;
    }
    @Transactional(readOnly = true)
    public Page<SensorManageResponse> findAll(Pageable pageable){
        Page<SensorManageResponse> sensorManageList = sensorManageRepository.findAll(pageable).map(SensorManageResponse::new);
        return sensorManageList;
    }

    @Transactional
    public Long save(SensorManageRequest sensorManageRequest){
        SensorPos sensorPos = sensorPosRepository.findById(sensorManageRequest.getSensorPosId()).orElseThrow(SensorPosNotFoundException::new);
        sensorManageRequest.setSsPos(sensorPos);
        SensorManage saved = sensorManageRepository.save(sensorManageRequest.toEntity());
        return saved.getSsId();
    }
}