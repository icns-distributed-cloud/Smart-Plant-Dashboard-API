package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.*;
import icns.smartplantdashboardapi.dto.abnormalDetection.socket.SocketAbnormalDetectionResponse;
import icns.smartplantdashboardapi.dto.sensorData.SensorDataRequest;
import icns.smartplantdashboardapi.dto.sensorData.SensorDataResponse;
import icns.smartplantdashboardapi.dto.sensorData.socket.SocketSensorDataResponse;
import icns.smartplantdashboardapi.repository.AbnormalDetectionRepository;
import icns.smartplantdashboardapi.repository.SensorDataRepository;
import icns.smartplantdashboardapi.repository.SensorManageRepository;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorDataService {
    private final SensorDataRepository sensorDataRepository;
    private final SensorManageRepository sensorManageRepository;
    private final SensorPosRepository sensorPosRepository;
    private final AbnormalDetectionRepository abnormalDetectionRepository;
    private final SimpMessageSendingOperations messageSendingOperations;
    @Transactional
    public Long save(SensorDataRequest sensorDataRequest) throws Exception{
        SensorManage sensorManage = sensorManageRepository.findById(sensorDataRequest.getSensorManageId()).orElseThrow(SensorManageNotFoundException::new);

        // update sensor state
        Integer pastState = sensorManage.getSensorState();
        sensorManage.setSensorState(sensorDataRequest.getInputData());

        // save
        SensorData saved = sensorDataRepository.save(sensorDataRequest.toEntity(sensorManage));

        // detect
        detectAbnormal(pastState, sensorManage);

        return saved.getDataId();
    }

    @Transactional
    public void detectAbnormal(Integer pastState, SensorManage sensorManage) throws Exception {

        Integer currState = sensorManage.getSensorState();
        if(pastState == null){
            System.out.println("Seneor Data Start");
        }
        else if( currState > 1 && pastState < currState){
            AbnormalDetection abnormalDetection = new AbnormalDetection(sensorManage, sensorManage.getSensorState());
            abnormalDetectionRepository.save(abnormalDetection);
            alertState(abnormalDetection);
        }

    }

    public void alertState(AbnormalDetection abnormalDetection){
        messageSendingOperations.convertAndSend("/alert", new SocketAbnormalDetectionResponse(abnormalDetection));
    }


    @Transactional(readOnly = true)
    public List<SensorDataResponse> findByPosId(Long posId){
        SensorPos ssPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        return sensorDataRepository.findBySensorManage_SsPosOrderByCreatedAtDesc(ssPos).stream().map(SensorDataResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SocketSensorDataResponse sendData(Long ssId){
        SensorManage sensorManage = sensorManageRepository.findById(ssId).get();
        SensorData sensorData = sensorDataRepository.findTop1BySensorManageOrderByCreatedAtDesc(sensorManage);
        return new SocketSensorDataResponse(sensorData);
    }

    @Transactional
    public List<SensorData> clearOldData(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthAgo = now.minusMinutes(5);
        List<SensorData> deleted = sensorDataRepository.deleteByCreatedAtLessThan(oneMonthAgo);
        return deleted;
    }
}
