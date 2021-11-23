package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.domain.SopDetailContent;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailContentRequest;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailContentResponse;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import icns.smartplantdashboardapi.repository.SopDetailContentRepository;
import icns.smartplantdashboardapi.repository.SopDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SopDetailContentService {

    private final SopDetailRepository sopDetailRepository;
    private final SensorPosRepository sensorPosRepository;
    private final SopDetailContentRepository sopDetailContentRepository;

    @Transactional
    public Long save( SopDetailContentRequest sopDetailContentRequest){
        SopDetail sopDetail = sopDetailRepository.findById(sopDetailContentRequest.getTitleId()).get();


        SopDetailContent sopDetailContent;
        if(sopDetailContentRequest.isMessage()){
            SensorPos sensorPos = sensorPosRepository.findById(sopDetailContentRequest.getPosId()).get();
            sopDetailContent = sopDetailContentRepository.save(sopDetailContentRequest.toEntity(sopDetail, sensorPos));

        }else{
            sopDetailContent = sopDetailContentRepository.save(sopDetailContentRequest.toEntity(sopDetail, null));
        }
        return sopDetailContent.getId();
    }

    @Transactional
    public Long update(Long contentId, SopDetailContentRequest sopDetailContentRequest){
        SopDetailContent sopDetailContent = sopDetailContentRepository.findById(contentId).get();
        if(sopDetailContentRequest.isMessage()){
            SensorPos sensorPos = sensorPosRepository.findById(sopDetailContentRequest.getPosId()).get();
            sopDetailContent.update(sopDetailContentRequest, sensorPos);
        }else{

            sopDetailContent.update(sopDetailContentRequest, null);



        }

        SensorPos sensorPos = sensorPosRepository.findById(sopDetailContentRequest.getPosId()).get();
        return sopDetailContent.getId();
    }
    @Transactional(readOnly = true)
    public SopDetailContentResponse find(Long contentId){
        SopDetailContent sopDetailContent = sopDetailContentRepository.findById(contentId).get();
        return new SopDetailContentResponse(sopDetailContent);
    }
    @Transactional(readOnly = true)

    public List<SopDetailContentResponse> findAll(Long titleId){
        List<SopDetailContentResponse> sopDetailContentResponseList = sopDetailContentRepository.findBySopDetail_Id(titleId).stream().map(SopDetailContentResponse::new).collect(Collectors.toList());
        return sopDetailContentResponseList;
    }

    @Transactional
    public Long delete(Long contentId){
        sopDetailContentRepository.deleteById(contentId);
        return contentId;
    }
}
