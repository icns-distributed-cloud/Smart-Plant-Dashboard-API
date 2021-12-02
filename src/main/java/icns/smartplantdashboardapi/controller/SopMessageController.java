package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.domain.User;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.repository.SopDetailContentRepository;
import icns.smartplantdashboardapi.repository.UserRepository;
import icns.smartplantdashboardapi.service.SopMessageService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"e-SOP 메시지"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SopMessageController {

    private final SopMessageService sopMessageService;
    private final UserRepository userRepository;


    @PostMapping("/message/send")
    public ResponseEntity sendMessage( @RequestParam(value = "contentId") Long contentId){ //@AuthenticationPrincipal UserDetails userDetails,
        //User user = userRepository.findByEmail(userDetails.getUsername()).get();

        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopMessageService.sendMessage("관리자", contentId)),null, HttpStatus.OK);
    }

    @GetMapping("/message/log")
    public ResponseEntity findLog(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopMessageService.findAll(pageable)),null, HttpStatus.OK);
    }

}
