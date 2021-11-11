package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.SensorData;
import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.sensorData.SensorDataRequest;
import icns.smartplantdashboardapi.dto.sensorData.SensorDataResponse;
import icns.smartplantdashboardapi.dto.socket.sensorData.SocketSensorDataResponse;
import icns.smartplantdashboardapi.repository.SensorDataRepository;
import icns.smartplantdashboardapi.repository.SensorManageRepository;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorDataService {
    private final SensorDataRepository sensorDataRepository;
    private final SensorManageRepository sensorManageRepository;
    private final SensorPosRepository sensorPosRepository;

    @Transactional
    public Long save(SensorDataRequest sensorDataRequest){
        SensorManage sensorManage = sensorManageRepository.findById(sensorDataRequest.getSensorManageId()).orElseThrow(SensorManageNotFoundException::new);
        SensorData saved = sensorDataRepository.save(sensorDataRequest.toEntity(sensorManage));
        return saved.getDataId();
    }


    @Transactional(readOnly = true)
    public List<SensorDataResponse> findByPosId(Long posId){
        SensorPos ssPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        return sensorDataRepository.findBySensorManage_SsPos(ssPos).stream().map(SensorDataResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SocketSensorDataResponse sendData(Long ssId){
        SensorManage sensorManage = sensorManageRepository.findById(ssId).get();
        SensorData sensorData = sensorDataRepository.findTop1BySensorManageOrderByCreatedAtDesc(sensorManage);
        return new SocketSensorDataResponse(sensorData.getSensorManage().getSsId(), sensorData.getInputData());
    }
}
