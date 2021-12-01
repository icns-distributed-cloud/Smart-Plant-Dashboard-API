package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailResponse;
import icns.smartplantdashboardapi.repository.SituationRepository;
import icns.smartplantdashboardapi.repository.SopDetailContentRepository;
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
    private final SituationRepository situationRepository;
    private final SopDetailContentRepository sopDetailContentRepository;


    @Transactional(readOnly = true)
    public SopDetailResponse find(Long titleId){
        SopDetail sopDetail = sopDetailRepository.findById(titleId).get();
        return new SopDetailResponse(sopDetail);
    }

    @Transactional
    public Long delete(Long nodeId){
        SopDetail sopDetail = sopDetailRepository.findByNodeId(nodeId).get();
        Long titleId = sopDetail.getId();
        sopDetailContentRepository.deleteBySopDetail_Id(titleId);
        sopDetailRepository.deleteByNodeId(nodeId);
        return titleId;
    }

    @Transactional(readOnly = true)
    public List<SopDetailResponse> findAll(Long situationId, Integer level){
        Situation situation = situationRepository.findById(situationId).get();

        List<SopDetailResponse> sopDetailResponseList = sopDetailRepository.findBySituationAndLevelOrderByY(situation, level).stream().map(SopDetailResponse::new).collect(Collectors.toList());
        return sopDetailResponseList;

    }



}
