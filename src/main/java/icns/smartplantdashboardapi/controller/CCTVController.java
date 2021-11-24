package icns.smartplantdashboardapi.controller;


import icns.smartplantdashboardapi.dto.cctv.CCTVRequest;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.CCTVService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"CCTV 정보 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CCTVController {

    private final CCTVService cctvService;

    @GetMapping("/cctv")
    public ResponseEntity findAll(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, cctvService.findAll(pageable)), null, HttpStatus.OK);
    }

    @PostMapping("/cctv")
    public ResponseEntity save(@RequestBody @Valid CCTVRequest cctvRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, cctvService.save(cctvRequest)), null, HttpStatus.OK);
    }

    @GetMapping("/cctv/{cctvId}")
    public ResponseEntity findById(@PathVariable Long cctvId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, cctvService.findById(cctvId)), null, HttpStatus.OK);
    }

    @DeleteMapping("/cctv/{cctvId}")
    public ResponseEntity deleteById(@PathVariable Long cctvId){
        cctvService.deleteById(cctvId);
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT,cctvId), null, HttpStatus.NO_CONTENT);
    }

}
