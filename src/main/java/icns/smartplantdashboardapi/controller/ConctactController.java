package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.abnormalDetection.contact.ContactRequest;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.ContactService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"e-SOP 연락처 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConctactController {
    private final ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity save(@RequestBody ContactRequest contactRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, contactService.save(contactRequest)), null, HttpStatus.CREATED);
    }

    @GetMapping("/contact")
    public ResponseEntity findAll(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, contactService.findAll(pageable)),null, HttpStatus.OK);

    }
}
