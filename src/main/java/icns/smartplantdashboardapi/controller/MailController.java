package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.MailService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"이메일 전송"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/mail/send")
    public ResponseEntity sendMail(@RequestParam(value = "contentId") Long contentId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, mailService.sendMail("관리자", contentId)), null, HttpStatus.OK);
    }

    @GetMapping("/mail/log")
    public ResponseEntity findLog(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, mailService.findAll(pageable)),null, HttpStatus.OK);
    }

}
