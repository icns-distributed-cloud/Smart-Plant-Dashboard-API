package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.MessageService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"e-SOP 메시지"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity sendMessage(){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, messageService.sendMessage()),null, HttpStatus.OK);
    }

}
