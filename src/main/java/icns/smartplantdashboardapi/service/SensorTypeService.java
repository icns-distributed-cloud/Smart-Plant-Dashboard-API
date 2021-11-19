package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.DuplicateException;
import icns.smartplantdashboardapi.advice.exception.SensorTypeNotFoundException;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeRequest;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeResponse;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import icns.smartplantdashboardapi.repository.SopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorTypeService {

    private final SensorTypeRepository sensorTypeRepository;
    private final SopRepository sopRepository;

    @Transactional(readOnly = true)
    public Page<SensorTypeResponse> findAll(Pageable pageable){
        Page<SensorTypeResponse> sensorTypeList = sensorTypeRepository.findAll(pageable).map(SensorTypeResponse::new);
        return sensorTypeList;
    }

    private void validateDuplication(SensorTypeRequest sensorType){
        sensorTypeRepository.findByTypeName(sensorType.getTypeName())
                .ifPresent(m ->{
                    throw new DuplicateException();
                });
        sensorTypeRepository.findByTypeCode(sensorType.getTypeCode())
                .ifPresent(m->{
                    throw new DuplicateException();
                });
    }

    @Transactional
    public Long save(SensorTypeRequest sensorTypeRequest){
        validateDuplication(sensorTypeRequest);
        SensorType saved = sensorTypeRepository.save(sensorTypeRequest.toEntity());

        for(int i=1;i<=4;i++){
            Sop sop = Sop.builder()
                    .level(i)
                    .ssType(saved)
                    .diagramPath(null)
                    .build();
            sopRepository.save(sop);
        }


        return saved.getTypeId();
    }

    @Transactional(readOnly = true)
    public SensorTypeResponse findById(Long typeId){
        SensorType sensorType = sensorTypeRepository.findById(typeId)
                .orElseThrow(SensorTypeNotFoundException::new);
        return new SensorTypeResponse(sensorType);
    }

    @Transactional
    public SensorTypeResponse updateById(Long typeId, SensorTypeRequest sensorTypeRequest){
        SensorType sensorType = sensorTypeRepository.findById(typeId).orElseThrow(SensorTypeNotFoundException::new);
        sensorType.update(sensorTypeRequest);
        return new SensorTypeResponse(sensorType);
    }
    @Transactional
    public void deleteById(Long typeId){
        sensorTypeRepository.deleteById(typeId);
    }
}
