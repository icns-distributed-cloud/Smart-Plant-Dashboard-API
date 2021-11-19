package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.advice.exception.SensorTypeNotFoundException;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.domain.SensorType;
import icns.smartplantdashboardapi.domain.Sop;
import icns.smartplantdashboardapi.dto.sop.SopRequest;
import icns.smartplantdashboardapi.dto.sop.SopResponse;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import icns.smartplantdashboardapi.repository.SensorTypeRepository;
import icns.smartplantdashboardapi.repository.SopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public SopResponse update(Long typeId, Integer level, MultipartFile diagramFile) throws IOException {
        SensorType sensorType = sensorTypeRepository.findById(typeId).orElseThrow(SensorTypeNotFoundException::new);

        Sop sop = sopRepository.findBySsTypeAndLevel(sensorType,level).get();

        String path;

        if(sop.getDiagramPath() == null){
            path = getFilePath(typeId, level);

        }else{
            path = sop.getDiagramPath();
        }
        sop.update(path);
        File file = new File(path);
        diagramFile.transferTo(file);
        return new SopResponse(sop);
    }

    @Transactional
    public SopResponse find(Long typeId, Integer level){
        SensorType sensorType = sensorTypeRepository.findById(typeId).orElseThrow(SensorTypeNotFoundException::new);

        Sop sop = sopRepository.findBySsTypeAndLevel(sensorType,level).get();

        return new SopResponse(sop);


    }


}
