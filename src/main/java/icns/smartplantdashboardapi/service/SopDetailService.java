package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailRequest;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailResponse;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailTitleParseResponse;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailUpdateRequest;
import icns.smartplantdashboardapi.repository.SituationRepository;
import icns.smartplantdashboardapi.repository.SopDetailRepository;
import icns.smartplantdashboardapi.repository.SopDetailTitleParseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SopDetailService {

    private final SopDetailRepository sopDetailRepository;
    private final SituationRepository situationRepository;
    private final SopDetailTitleParseRepository sopDetailTitleParseRepository;


    @Transactional
    public Long save(SopDetailRequest sopDetailRequest){
        Situation situation = situationRepository.findById(sopDetailRequest.getSituationId()).get();
        SopDetail sopDetail = sopDetailRepository.save(sopDetailRequest.toEntity(situation));
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
    public List<SopDetailResponse> findAll(Long situationId, Integer level){
        Situation situation = situationRepository.findById(situationId).get();

        List<SopDetailResponse> sopDetailResponseList = sopDetailRepository.findBySituationAndLevel(situation, level).stream().map(SopDetailResponse::new).collect(Collectors.toList());
        return sopDetailResponseList;

    }

    @Transactional(readOnly = true)
    public SopDetailTitleParseResponse findTitleParseList(Long situationId, Integer level){
        Situation situation = situationRepository.findById(situationId).get();
        List<String> titleList = new ArrayList<>();

        sopDetailTitleParseRepository.findBySituationAndLevel(situation, level).stream().forEach(x -> titleList.add(x.getTitle()));

        SopDetailTitleParseResponse sopDetailTitleParseResponse = new SopDetailTitleParseResponse(titleList);
        return sopDetailTitleParseResponse;

    }


}
