package icns.smartplantdashboardapi.advice;

import icns.smartplantdashboardapi.advice.exception.*;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.Msg;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

        return new ResponseEntity(CommonResponse.res(StatusCode.BAD_REQUEST, Msg.NOT_FOUND_SENSOR_POS,null), null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorManageNotFoundException.class)
    public ResponseEntity sensorManageNotFoundException(SensorManageNotFoundException e){
        return new ResponseEntity(CommonResponse.res(StatusCode.BAD_REQUEST,Msg.NOT_FOUND_SENSOR,null), null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorTypeNotFoundException.class)
    public ResponseEntity sensorTypeNotFoundException(SensorTypeNotFoundException e){
        return new ResponseEntity(CommonResponse.res(StatusCode.BAD_REQUEST, Msg.NOT_FOUND_SENSOR_TYPE, null), null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity duplicateException(DuplicateException e){
        return new ResponseEntity(CommonResponse.res(StatusCode.CONFLICT, Msg.DUPLICATE, null), null, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity mothodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ResponseEntity(CommonResponse.res(StatusCode.BAD_REQUEST, Msg.REQUEST_NOT_VALID, null), null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity UnAuthorizedException(UnAuthorizedException e){
        return new ResponseEntity(CommonResponse.res(StatusCode.UNAUTHORIZED, Msg.NOTAUTHENTICATED), null, HttpStatus.UNAUTHORIZED);
    }


}
