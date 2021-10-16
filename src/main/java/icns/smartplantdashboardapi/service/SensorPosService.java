package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.DuplicateException;
import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SensorPosService {

    private final SensorPosRepository sensorPosRepository;

    @Transactional(readOnly = true)
    public Page<SensorPosResponse> findAll(Pageable pageable){
        Page<SensorPosResponse> sensorPosList = sensorPosRepository.findAll(pageable).map(SensorPosResponse::new);
        return sensorPosList;
    }
    /*
    @Transactional(readOnly = true)
    public List<SensorPosResponse> findAll(){
        return sensorPosRepository.findAll()
                .stream()
                .map(SensorPosResponse::new)
                .collect(Collectors.toList());
    }
     */

    private void validateDuplication(SensorPosRequest sensorPos){
        sensorPosRepository.findByPosName(sensorPos.getPosName())
                .ifPresent(m ->{
                    throw new DuplicateException();
                });
        sensorPosRepository.findByPosCode(sensorPos.getPosCode())
                .ifPresent(m->{
                    throw new DuplicateException();
                });
    }

    @Transactional
    public Long save(SensorPosRequest sensorPosRequest){
        validateDuplication(sensorPosRequest);
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
    public SensorPosResponse updateById(Long posId, SensorPosRequest sensorPosRequest){
        SensorPos sensorPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        sensorPos.update(sensorPosRequest);
        return new SensorPosResponse(sensorPos);
    }

    @Transactional
    public Long deleteById(Long posId){
        Long deleted = sensorPosRepository.getById(posId).getPosId();
        sensorPosRepository.deleteById(posId);
        return deleted;
    }
}