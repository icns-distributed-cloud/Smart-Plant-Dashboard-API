package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.repository.SopDetailContentRepository;
import icns.smartplantdashboardapi.service.SopMessageService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"e-SOP 메시지"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SopMessageController {

    private final SopMessageService sopMessageService;

    @PostMapping("/message/send")
    public ResponseEntity sendMessage(@RequestParam(value = "contentId") Long contentId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopMessageService.sendMessage(contentId)),null, HttpStatus.OK);
    }

    @GetMapping("/message/log")
    public ResponseEntity findLog(){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopMessageService.findAll()),null, HttpStatus.OK);
    }

}
