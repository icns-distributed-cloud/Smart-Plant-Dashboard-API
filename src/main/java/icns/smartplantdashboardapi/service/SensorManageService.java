package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
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
    public Page<SensorManageResponse> find(Long posId, Pageable pageable){
        Page<SensorManageResponse> sensorManageList;
        if(posId == null){
            sensorManageList = sensorManageRepository.findAll(pageable).map(SensorManageResponse::new);

        }else{
            sensorManageList = sensorManageRepository.findBySsPos_PosId(posId, pageable).map(SensorManageResponse::new);
        }
        return sensorManageList;
    }


    @Transactional
    public Long save(SensorManageRequest sensorManageRequest){
        SensorPos sensorPos = sensorPosRepository.findById(sensorManageRequest.getSensorPosId()).orElseThrow(SensorPosNotFoundException::new);
        sensorManageRequest.setSsPos(sensorPos);
        SensorManage saved = sensorManageRepository.save(sensorManageRequest.toEntity());
        return saved.getSsId();
    }

    @Transactional
    public SensorManageResponse updateById(Long ssId, SensorManageRequest sensorManageRequest){
        SensorManage sensorManage = sensorManageRepository.findById(ssId).orElseThrow(SensorManageNotFoundException::new);
        SensorPos sensorPos = sensorPosRepository.findById(sensorManageRequest.getSensorPosId()).orElseThrow(SensorPosNotFoundException::new);
        sensorManageRequest.setSsPos(sensorPos);
        sensorManage.update(sensorManageRequest);
        return new SensorManageResponse(sensorManage);
    }

    @Transactional(readOnly = true)
    public SensorManageResponse findById(Long ssId){
        SensorManage sensorManage = sensorManageRepository.findById(ssId)
                .orElseThrow(SensorManageNotFoundException::new);
        return new SensorManageResponse(sensorManage);
    }


    @Transactional
    public void deleteById(Long ssId){
        sensorManageRepository.deleteById(ssId);
    }
}