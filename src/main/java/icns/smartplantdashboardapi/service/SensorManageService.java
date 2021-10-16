package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.advice.exception.SensorTypeNotFoundException;
import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.repository.SensorManageRepository;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class SensorManageService {

    private final SensorManageRepository sensorManageRepository;
    private final SensorPosRepository sensorPosRepository;
    private final SensorTypeRepository sensorTypeRepository;

    @Transactional
    public Long save(SensorManageRequest sensorManageRequest){
        SensorPos sensorPos = sensorPosRepository.findById(sensorManageRequest.getSensorPosId()).orElseThrow(SensorPosNotFoundException::new);
        SensorType sensorType = sensorTypeRepository.findById(sensorManageRequest.getSensorTypeId()).orElseThrow(SensorTypeNotFoundException::new);
        SensorManage saved = sensorManageRepository.save(sensorManageRequest.toEntity(sensorPos, sensorType));
        saved.createSensorCode();
        saved.createDefaultSensorRange();
        return saved.getSsId();
    }

    @Transactional
    public SensorManageResponse updateById(Long ssId, SensorManageRequest sensorManageRequest){
        SensorManage sensorManage = sensorManageRepository.findById(ssId).orElseThrow(SensorManageNotFoundException::new);
        SensorPos sensorPos = sensorPosRepository.findById(sensorManageRequest.getSensorPosId()).orElseThrow(SensorPosNotFoundException::new);
        SensorType sensorType = sensorTypeRepository.findById(sensorManageRequest.getSensorTypeId()).orElseThrow(SensorTypeNotFoundException::new);

        sensorManage.update(sensorManageRequest, sensorPos, sensorType);
        sensorManage.createSensorCode();
        return new SensorManageResponse(sensorManage);
    }

    @Transactional(readOnly = true)
    public SensorManageResponse findById(Long ssId){
        SensorManage sensorManage = sensorManageRepository.findById(ssId)
                .orElseThrow(SensorManageNotFoundException::new);
        return new SensorManageResponse(sensorManage);
    }


    @Transactional
    public Long deleteById(Long ssId){
        Long deleted = sensorManageRepository.getById(ssId).getSsId();
        sensorManageRepository.deleteById(ssId);
        return deleted;
    }

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
}