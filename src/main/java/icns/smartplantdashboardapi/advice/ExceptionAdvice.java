package icns.smartplantdashboardapi.advice;

import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public CommonResponse<String> defaultException(Exception e){
        log.info(String.valueOf(e));
        return new CommonResponse<>(false, e.getMessage(), null);
    }

    @ExceptionHandler(SensorPosNotFoundException.class)
    public CommonResponse<String> sensorPosnotFoundException(SensorPosNotFoundException e){
        return new CommonResponse<>(false, "해당 Id를 가진 센서 위치를 찾을 수 없습니다.", null);
    }
}
