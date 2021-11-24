package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.domain.Situation;
import icns.smartplantdashboardapi.domain.SopDetail;
import icns.smartplantdashboardapi.domain.SopDiagram;
import icns.smartplantdashboardapi.dto.sopDiagram.SopDiagramRequest;
import icns.smartplantdashboardapi.dto.sopDiagram.SopDiagramResponse;
import icns.smartplantdashboardapi.repository.SituationRepository;
import icns.smartplantdashboardapi.repository.SopDetailRepository;
import icns.smartplantdashboardapi.repository.SopDiagramRepository;
import lombok.RequiredArgsConstructor;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SopDiagramService {
    private final SopDiagramRepository sopDiagramRepository;
    private final SituationRepository situationRepository;
    private final SopDetailRepository sopDetailRepository;

    private String getFilePath(Long situationId, Integer level){
        String absolutePath = new File("").getAbsolutePath() + "/sop-diagram/";
        String fileName = situationId + "-" + level.toString() + ".txt";

        String path = absolutePath + fileName;
        return path;
    }

    @Transactional
    public Long updateDiagram(SopDiagramRequest sopDiagramRequest) throws IOException {
        Situation situation = situationRepository.findById(sopDiagramRequest.getSituationId()).get();
        SopDiagram sopDiagram = sopDiagramRepository.findBySituationAndLevel(situation, sopDiagramRequest.getLevel()).get();


        // JSON Parsing
        JSONObject jsonObject = new JSONObject(sopDiagramRequest.getDiagram());
        JSONArray jsonArray = jsonObject.getJSONArray("node");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            JSONObject styleObj = obj.getJSONObject("style");
            String text = styleObj.getString("text");
            JSONArray position = obj.getJSONArray("position");
            Long nodeId = obj.getLong("id");
            float y = position.getFloat(1);

            Optional<SopDetail> sopDetail = sopDetailRepository.findByNodeId(nodeId);
            if(sopDetail.isPresent()){
                sopDetail.get().update(text,y);
            }else{
                SopDetail newSopDetail = SopDetail.builder()
                        .level(sopDiagramRequest.getLevel())
                        .situation(situation)
                        .nodeId(nodeId)
                        .title(text)
                        .y(y)
                        .build();
                sopDetailRepository.save(newSopDetail);
            }

        }

        // Save File
        String diagramPath = getFilePath(sopDiagramRequest.getSituationId(), sopDiagramRequest.getLevel());
        FileWriter fileWriter = new FileWriter(diagramPath);
        fileWriter.write(sopDiagramRequest.getDiagram());
        fileWriter.close();

        sopDiagram.update(diagramPath);
        return sopDiagram.getId();
    }

    @Transactional(readOnly = true)
    public SopDiagramResponse findDiagram(Long situationId, Integer level) throws IOException{
        Situation situation = situationRepository.findById(situationId).get();
        SopDiagram sopDiagram = sopDiagramRepository.findBySituationAndLevel(situation, level).get();
        if(sopDiagram.getDiagramPath() == null){
            return new SopDiagramResponse(sopDiagram, null);
        }else{
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(sopDiagram.getDiagramPath())
            );
            String diagram = bufferedReader.readLine();
            return new SopDiagramResponse(sopDiagram, diagram);
        }


    }




}
