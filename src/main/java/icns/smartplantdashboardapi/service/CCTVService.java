package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.CCTVNotFoundException;
import icns.smartplantdashboardapi.domain.CCTV;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.cctv.CCTVRequest;
import icns.smartplantdashboardapi.dto.cctv.CCTVResponse;
import icns.smartplantdashboardapi.repository.CCTVRepository;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CCTVService {
    private final CCTVRepository cctvRepository;
    private final SensorPosRepository sensorPosRepository;

    @Transactional(readOnly = true)
    public Page<CCTVResponse> findAll(Pageable pageable){
        Page<CCTVResponse> cctvList = cctvRepository.findAll(pageable).map(CCTVResponse::new);
        return cctvList;
    }

    @Transactional
    public Long save(CCTVRequest cctvRequest){
        SensorPos sensorPos = sensorPosRepository.findById(cctvRequest.getPosId()).get();
        CCTV saved = cctvRepository.save(cctvRequest.toEntity(sensorPos));
        return saved.getCctvId();
    }

    @Transactional(readOnly = true)
    public CCTVResponse findById(Long cctvId){
        CCTV cctv = cctvRepository.findById(cctvId)
                .orElseThrow(CCTVNotFoundException::new);
        return new CCTVResponse(cctv);
    }

    @Transactional
    public Long deleteById(Long cctvId){
        Long deleted = cctvRepository.getById(cctvId).getCctvId();
        cctvRepository.deleteById(cctvId);
        return deleted;
    }
}
