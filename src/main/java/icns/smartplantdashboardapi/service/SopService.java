package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorTypeNotFoundException;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.dto.sop.SopResponse;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import icns.smartplantdashboardapi.repository.SopRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SopService {
    private final SopRepository sopRepository;
    private final SensorTypeRepository sensorTypeRepository;

    private String getFilePath(Long typeId, Integer level){

        // set file name
        String absolutePath = new File("").getAbsolutePath() + "\\sop-diagram\\";
        String fileName = typeId + "-" + level.toString() + ".json";

        String path = absolutePath + fileName;
        return path;
    }

    @Transactional
    public SopResponse update(Long typeId, Integer level, MultipartFile diagramFile) throws IOException, ParseException {
        SensorType sensorType = sensorTypeRepository.findById(typeId).orElseThrow(SensorTypeNotFoundException::new);

        Sop sop = sopRepository.findBySsTypeAndLevel(sensorType,level).get();

        String path;

        if(sop.getDiagramPath() == null){
            path = getFilePath(typeId, level);

        }else{
            path = sop.getDiagramPath();
        }
        sop.update(path);
        System.out.println(path);
        File file = new File(path);
        diagramFile.transferTo(file);
        parsingJsonText(typeId,level,path);

        return new SopResponse(sop);
    }

    private void parsingJsonText(Long typeId, Integer level, String path) throws IOException, ParseException {
        List<String> titleList;
        System.out.println(path);
        JSONParser jsonParser = new JSONParser();
        Reader reader = new FileReader(path);
//        JSONArray nodes = jsonObject.getJSONArray("node");
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        for(int i=0;i<nodes.length();i++){
//            JSONObject node = nodes.getJSONObject(i);
//            String text = node.getString("title");
//
//            System.out.println(text);
//
//        }

    }

    @Transactional
    public SopResponse find(Long typeId, Integer level){
        SensorType sensorType = sensorTypeRepository.findById(typeId).orElseThrow(SensorTypeNotFoundException::new);

        Sop sop = sopRepository.findBySsTypeAndLevel(sensorType,level).get();

        return new SopResponse(sop);


    }


}
