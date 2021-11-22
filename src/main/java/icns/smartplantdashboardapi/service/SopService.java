package icns.smartplantdashboardapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import icns.smartplantdashboardapi.advice.exception.SensorTypeNotFoundException;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.domain.SopDetailTitleParse;
import icns.smartplantdashboardapi.dto.sop.SopRequest;
import icns.smartplantdashboardapi.dto.sop.SopResponse;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import icns.smartplantdashboardapi.repository.SopDetailTitleParseRepository;
import icns.smartplantdashboardapi.repository.SopRepository;
import lombok.RequiredArgsConstructor;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SopService {
    private final SopRepository sopRepository;
    private final SensorTypeRepository sensorTypeRepository;
    private final SopDetailTitleParseRepository sopDetailTitleParseRepository;

    private String getFilePath(Long typeId, Integer level){
        String absolutePath = new File("").getAbsolutePath() + "/sop-diagram/";
        String fileName = typeId + "-" + level.toString() + ".text";

        String path = absolutePath + fileName;
        return path;
    }

    @Transactional
    public Long updateDiagram(SopRequest sopRequest) throws IOException {
        SensorType sensorType = sensorTypeRepository.findById(sopRequest.getTypeId()).get();
        Sop sop = sopRepository.findBySsTypeAndLevel(sensorType, sopRequest.getLevel()).get();

        sopDetailTitleParseRepository.deleteBySsTypeAndLevel(sensorType, sopRequest.getLevel());

        // JSON Parsing
        JSONObject jsonObject = new JSONObject(sopRequest.getDiagram());
        JSONArray jsonArray = jsonObject.getJSONArray("node");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            JSONObject styleObj = obj.getJSONObject("style");
            String text = styleObj.getString("text");
            SopDetailTitleParse sopDetailTitleParse = SopDetailTitleParse.builder()
                        .ssType(sensorType)
                        .level(sopRequest.getLevel())
                        .title(text)
                        .build();
            sopDetailTitleParseRepository.save(sopDetailTitleParse);

        }

        // Save File
        String diagramPath = getFilePath(sopRequest.getTypeId(), sopRequest.getLevel());
        FileWriter fileWriter = new FileWriter(diagramPath);
        fileWriter.write(sopRequest.getDiagram());
        fileWriter.close();

        sop.update(diagramPath);
        return sop.getId();
    }

    @Transactional(readOnly = true)
    public SopResponse findDiagram(Long typeId,Integer level) throws IOException{
        SensorType sensorType = sensorTypeRepository.findById(typeId).get();
        Sop sop = sopRepository.findBySsTypeAndLevel(sensorType, level).get();
        if(sop.getDiagramPath() == null){
            return new SopResponse(sop, null);
        }else{
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(sop.getDiagramPath())
            );
            String diagram = bufferedReader.readLine();
            return new SopResponse(sop, diagram);
        }


    }




}
