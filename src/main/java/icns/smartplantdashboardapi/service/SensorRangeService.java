package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
import icns.smartplantdashboardapi.domain.SensorManage;
import icns.smartplantdashboardapi.dto.sensorManage.range.SensorRangeRequest;
import icns.smartplantdashboardapi.dto.sensorManage.range.SensorRangeResponse;
import icns.smartplantdashboardapi.repository.SensorManageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SensorRangeService {
    private final SensorManageRepository sensorManageRepository;

    @Transactional(readOnly = true)
    public Page<SensorRangeResponse> findByPosId(Long posId, Pageable pageable){
        Page<SensorRangeResponse> sensorRangeList = sensorManageRepository.findBySsPos_PosId(posId, pageable).map(SensorRangeResponse::new);
        return sensorRangeList;
    }

    @Transactional(readOnly = true)
    public SensorRangeResponse findBySsId(Long ssId){
        SensorManage sensorManage = sensorManageRepository.findById(ssId).orElseThrow(SensorManageNotFoundException::new);
        return new SensorRangeResponse(sensorManage);
    }

    @Transactional
    public SensorRangeResponse updateById(Long ssId, SensorRangeRequest sensorRangeRequest){
        SensorManage sensorManage = sensorManageRepository.findById(ssId).orElseThrow(SensorManageNotFoundException::new);
        sensorManage.updateRange(sensorRangeRequest);
        return new SensorRangeResponse(sensorManage);
    }

}
