package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.domain.SopDetailContent;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailContentRequest;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailContentResponse;
import icns.smartplantdashboardapi.repository.SopDetailContentRepository;
import icns.smartplantdashboardapi.repository.SopDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SopDetailContentService {

    private final SopDetailRepository sopDetailRepository;
    private final SopDetailContentRepository sopDetailContentRepository;

    public Long save( SopDetailContentRequest sopDetailContentRequest){
        SopDetail sopDetail = sopDetailRepository.findById(sopDetailContentRequest.getTitleId()).get();
        SopDetailContent sopDetailContent = sopDetailContentRepository.save(sopDetailContentRequest.toEntity(sopDetail));
        return sopDetailContent.getId();
    }

    public SopDetailContentResponse find(Long contentId){
        SopDetailContent sopDetailContent = sopDetailContentRepository.findById(contentId).get();
        return new SopDetailContentResponse(sopDetailContent);
    }

    public List<SopDetailContentResponse> findAll(Long titleId){
        List<SopDetailContentResponse> sopDetailContentResponseList = sopDetailContentRepository.findBySopDetail_Id(titleId).stream().map(SopDetailContentResponse::new).collect(Collectors.toList());
        return sopDetailContentResponseList;
    }

    public Long delete(Long contentId){
        sopDetailContentRepository.deleteById(contentId);
        return contentId;
    }
}
