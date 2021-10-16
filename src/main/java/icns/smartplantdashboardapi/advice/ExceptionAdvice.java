package icns.smartplantdashboardapi.advice;

import icns.smartplantdashboardapi.advice.exception.DuplicateException;
import icns.smartplantdashboardapi.advice.exception.SensorManageNotFoundException;
import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.Msg;
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

        return new ResponseEntity(CommonResponse.res(StatusCode.NOT_FOUND, Msg.NOT_FOUND_SENSOR_POS,null), null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SensorManageNotFoundException.class)
    public ResponseEntity sensorManageNotFoundException(SensorManageNotFoundException e){
        return new ResponseEntity(CommonResponse.res(StatusCode.NOT_FOUND,Msg.NOT_FOUND_SENSOR,null), null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity duplicateException(DuplicateException e){
        return new ResponseEntity(CommonResponse.res(StatusCode.CONFLICT, Msg.DUPLICATE, null), null, HttpStatus.CONFLICT);
    }
}