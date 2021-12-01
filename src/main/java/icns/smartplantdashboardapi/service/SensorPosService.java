package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
@RequiredArgsConstructor
public class SensorPosService {

    private final SensorPosRepository sensorPosRepository;

    @Transactional(readOnly = true)
    public Page<SensorPosResponse> findAll(Pageable pageable){
        Page<SensorPosResponse> sensorPosList = sensorPosRepository.findAll(pageable).map(SensorPosResponse::new);
        return sensorPosList;
    }
    /*
    @Transactional(readOnly = true)
    public List<SensorPosResponse> findAll(){
        return sensorPosRepository.findAll()
                .stream()
                .map(SensorPosResponse::new)
                .collect(Collectors.toList());
    }
     */



    @Transactional
    public Long save(String posName, String posCode, String posDtl, MultipartFile backgroundImg) throws IOException{

        SensorPos sensorPos = SensorPos.builder()
                                    .posName(posName)
                                    .positionImgPath(null)
                                    .positionPath(null)
                                    .backgroundImgPath(null)
                                    .posDtl(posDtl)
                                    .posCode(posCode)
                                    .build();
        SensorPos saved = sensorPosRepository.save(sensorPos);

        String path = getBackgroundImgPath(saved.getPosId());
        File file = new File(path);
        backgroundImg.transferTo(file);
        saved.setBackgroundImgPath(path);
        return saved.getPosId();
    }

    @Transactional(readOnly = true)
    public SensorPosResponse findById(Long posId) throws IOException {
        SensorPos sensorPos = sensorPosRepository.findById(posId)
                        .orElseThrow(SensorPosNotFoundException::new);
        if(sensorPos.getPositionPath() == null){
            return new SensorPosResponse(sensorPos, null);
        }else {
            BufferedReader bufferedReader = new BufferedReader(
                new FileReader(sensorPos.getPositionPath())
            );
            String diagram = bufferedReader.readLine();
            return new SensorPosResponse(sensorPos, diagram);
        }
    }

    @Transactional
    public Long updateById(Long posId, SensorPosRequest sensorPosRequest){
        SensorPos sensorPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        sensorPos.update(sensorPosRequest);
        return sensorPos.getPosId();
    }

    @Transactional
    public Long deleteById(Long posId){
        Long deleted = sensorPosRepository.getById(posId).getPosId();
        sensorPosRepository.deleteById(posId);
        return deleted;
    }


    @Transactional
    public String updateBackgroundImg(Long posId, MultipartFile backgroundImg) throws IOException {
        SensorPos sensorPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        String path = getBackgroundImgPath(posId);
        File file = new File(path);
        backgroundImg.transferTo(file);

        return sensorPos.getBackgroundImgPath();
    }

    @Transactional
    public Long updatePosition(Long posId, String position,MultipartFile backgroundImg ) throws IOException{
        SensorPos sensorPos = sensorPosRepository.findById(posId).orElseThrow(SensorPosNotFoundException::new);
        String positionImgPath = getPositionImgPath(posId);
        File file = new File(positionImgPath);
        backgroundImg.transferTo(file);

        System.out.println(position);
        String positionPath = getPositionPath(posId);
        FileWriter fileWriter = new FileWriter(positionPath);
        fileWriter.write(position);
        fileWriter.close();



        sensorPos.updatePosition(positionImgPath, positionPath);

        return sensorPos.getPosId();

    }

    private String getBackgroundImgPath(Long posId){
        // set file name
        String absolutePath = new File("").getAbsolutePath() + "/pos/";
        String fileName = "back-"+posId+".png";
        String path = absolutePath + fileName;
        return path;
    }

    private String getPositionImgPath(Long posId){
        // set file name
        String absolutePath = new File("").getAbsolutePath() + "/pos/";
        String fileName = "positionImg-"+posId+".png";
        String path = absolutePath + fileName;
        return path;
    }
    private String getPositionPath(Long posId){
        // set file name
        String absolutePath = new File("").getAbsolutePath() + "/pos/";
        String fileName = "position-"+posId+".txt";
        String path = absolutePath + fileName;
        return path;
    }

}
