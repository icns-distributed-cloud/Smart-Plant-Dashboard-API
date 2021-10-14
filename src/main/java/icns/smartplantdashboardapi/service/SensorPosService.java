package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorPosService {

    private final SensorPosRepository sensorPosRepository;

    @Transactional(readOnly = true)
    public List<SensorPosResponse> findAll(){
        return sensorPosRepository.findAll()
                .stream()
                .map(SensorPosResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(SensorPosRequest sensorPosRequest){
        SensorPos saved = sensorPosRepository.save(sensorPosRequest.toEntity());
        return saved.getPosId();
    }

    @Transactional(readOnly = true)
    public SensorPosResponse findById(Long posId){
        SensorPos sensorPos = sensorPosRepository.findById(posId)
                        .orElseThrow(SensorPosNotFoundException::new);
        return new SensorPosResponse(sensorPos);
    }

    @Transactional
    public void deleteById(Long posId){
        sensorPosRepository.deleteById(posId);
    }
}
