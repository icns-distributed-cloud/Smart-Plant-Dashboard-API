package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.dto.sop.SopDetailRequest;
import icns.smartplantdashboardapi.dto.sop.SopDetailResponse;
import icns.smartplantdashboardapi.dto.sop.SopDetailUpdateRequest;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import icns.smartplantdashboardapi.repository.SopDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SopDetailService {

    private final SopDetailRepository sopDetailRepository;
    private final SensorTypeRepository sensorTypeRepository;

    @Transactional
    public Long save(SopDetailRequest sopDetailRequest){
        SensorType sensorType = sensorTypeRepository.findById(sopDetailRequest.getTypeId()).get();
        SopDetail sopDetail = sopDetailRepository.save(sopDetailRequest.toEntity(sensorType));
        return sopDetail.getId();
    }

    @Transactional
    public Long update(Long titleId, SopDetailUpdateRequest sopDetailUpdateRequest){
        SopDetail sopDetail = sopDetailRepository.findById(titleId).get();
        sopDetail.update(sopDetailUpdateRequest.getTitle());
        return sopDetail.getId();
    }

    @Transactional(readOnly = true)
    public SopDetailResponse find(Long titleId){
        SopDetail sopDetail = sopDetailRepository.findById(titleId).get();
        return new SopDetailResponse(sopDetail);
    }

    @Transactional
    public Long delete(Long titleId){
        sopDetailRepository.deleteById(titleId);
        return titleId;
    }

    @Transactional(readOnly = true)
    public List<SopDetailResponse> findAll(Long typeId, Integer level){
        SensorType sensorType = sensorTypeRepository.findById(typeId).get();

        List<SopDetailResponse> sopDetailResponseList = sopDetailRepository.findBySsTypeAndLevel(sensorType, level).stream().map(SopDetailResponse::new).collect(Collectors.toList());
        return sopDetailResponseList;

    }


}
