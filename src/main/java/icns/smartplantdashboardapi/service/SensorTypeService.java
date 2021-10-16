package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeRequest;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeResponse;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorTypeService {
    private final SensorTypeRepository sensorTypeRepository;

    @Transactional(readOnly = true)
    public List<SensorTypeResponse> findAll(){
        return sensorTypeRepository.findAll()
                .stream()
                .map(SensorTypeResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(SensorTypeRequest sensorTypeRequest){
        SensorType saved = sensorTypeRepository.save(sensorTypeRequest.toEntity());
        return saved.getTypeId();
    }

    @Transactional(readOnly = true)
    public SensorTypeResponse findById(Long typeId){
        SensorType sensorType = sensorTypeRepository.findById(typeId)
                .orElseThrow();
        return new SensorTypeResponse(sensorType);
    }

    @Transactional
    public void deleteById(Long typeId){
        sensorTypeRepository.deleteById(typeId);
    }
}
