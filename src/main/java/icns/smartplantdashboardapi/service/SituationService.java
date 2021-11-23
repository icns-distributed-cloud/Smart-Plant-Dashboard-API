package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.dto.situation.SituationRequest;
import icns.smartplantdashboardapi.dto.situation.SituationResponse;
import icns.smartplantdashboardapi.repository.SituationRepository;
import icns.smartplantdashboardapi.repository.SopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SituationService {
    private final SituationRepository situationRepository;
    private final SopRepository sopRepository;

    @Transactional
    public Long save(SituationRequest situationRequest){
        Situation saved =  situationRepository.save(situationRequest.toEntity());
        for(int i=1;i<=4;i++){
            Sop sop = Sop.builder()
                    .level(i)
                    .situation(saved)
                    .diagramPath(null)
                    .build();
            sopRepository.save(sop);
        }
        return saved.getId();
    }

    @Transactional(readOnly = true)
    public SituationResponse find(Long situationId){
        Situation situation = situationRepository.findById(situationId).get();
        return new SituationResponse(situation);
    }

    @Transactional(readOnly = true)
    public List<SituationResponse> findAll(){
        List<SituationResponse> situationResponseList = situationRepository.findAll().stream().map(SituationResponse::new).collect(Collectors.toList());
        return situationResponseList;
    }

    @Transactional
    public Long update(Long situationId, SituationRequest situationRequest){
        Situation situation = situationRepository.findById(situationId).get();
        situation.update(situationRequest.getName());
        return situation.getId();
    }

    @Transactional
    public Long delete(Long situationId){
        situationRepository.deleteById(situationId);
        return situationId;
    }
}
