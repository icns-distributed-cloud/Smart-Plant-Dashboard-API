package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.Accident;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.accident.AccidentResponse;
import icns.smartplantdashboardapi.dto.accident.AccidentType;
import icns.smartplantdashboardapi.dto.sensorData.SensorDataResponse;
import icns.smartplantdashboardapi.repository.AccidentRepository;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccidentService {
    private final AccidentRepository accidentRepository;
    private final SensorPosRepository sensorPosRepository;

    @Transactional
    public Long fire(Long posId){
        SensorPos sensorPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        Accident accident = Accident.builder()
                                .type(AccidentType.FIRE)
                                .ssPos(sensorPos)
                                .build();
        Accident saved = accidentRepository.save(accident);
        return saved.getId();
    }

    @Transactional
    public Long smoke(Long posId){
        SensorPos sensorPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        Accident accident = Accident.builder()
                .type(AccidentType.SMOKE)
                .ssPos(sensorPos)
                .build();
        Accident saved = accidentRepository.save(accident);
        return saved.getId();
    }

    @Transactional(readOnly = true)
    public List<AccidentResponse> findAll(){
        return accidentRepository.findAll().stream().map(AccidentResponse::new).collect(Collectors.toList());
    }
}
