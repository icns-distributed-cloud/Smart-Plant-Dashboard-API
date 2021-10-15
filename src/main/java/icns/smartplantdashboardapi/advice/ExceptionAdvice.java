package icns.smartplantdashboardapi.advice;

import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity defaultException(Exception e){
        return new ResponseEntity(CommonResponse.res(StatusCode.BAD_REQUEST,e.getMessage(),null), null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorPosNotFoundException.class)
    public ResponseEntity sensorPosNotFoundException(SensorPosNotFoundException e){
        String msg = "해당 Id를 가진 센서 위치를 찾을 수 없습니다.";
        return new ResponseEntity(CommonResponse.res(StatusCode.NOT_FOUND,msg,null), null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SensorManageNotFoundException.class)
    public ResponseEntity sensorManageNotFoundException(SensorManageNotFoundException e){
        String msg = "해당 Id를 가진 센서를 찾을 수 없습니다.";
        return new ResponseEntity(CommonResponse.res(StatusCode.NOT_FOUND,msg,null), null, HttpStatus.NOT_FOUND);
    }
}
