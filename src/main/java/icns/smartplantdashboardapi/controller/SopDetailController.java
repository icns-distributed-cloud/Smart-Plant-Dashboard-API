package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailContentRequest;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailRequest;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailUpdateRequest;
import icns.smartplantdashboardapi.service.SopDetailContentService;
import icns.smartplantdashboardapi.service.SopDetailService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"e-SOP 디테일 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SopDetailController {

    private final SopDetailService sopDetailService;
    private final SopDetailContentService sopDetailContentService;

    @PostMapping("/sop-detail")
    public ResponseEntity save(@RequestBody SopDetailRequest sopDetailRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, sopDetailService.save(sopDetailRequest)), null, HttpStatus.CREATED);
    }

    @PutMapping("/sop-detail/{titleId}")
    public ResponseEntity update(@PathVariable(value = "titleId") Long titleId, @RequestBody SopDetailUpdateRequest sopDetailUpdateRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,sopDetailService.update(titleId, sopDetailUpdateRequest)), null, HttpStatus.OK);
    }

    @GetMapping("/sop-detail/{titleId}")
    public ResponseEntity find(@PathVariable(value = "titleId") Long titleId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,sopDetailService.find(titleId)), null, HttpStatus.OK);
    }


    @GetMapping("/sop-detail")
    public ResponseEntity findAll(@RequestParam(value="situationId") Long situationId,@RequestParam(value="level") Integer level){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,sopDetailService.findAll(situationId, level)), null, HttpStatus.OK);
    }

    @DeleteMapping("/sop-detail/{titleId}")
    public ResponseEntity delete(@PathVariable(value = "titleId") Long titleId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailService.delete(titleId)), null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/sop-detail/title-list")
    public ResponseEntity findTitleParseList(@RequestParam(value="situationId") Long situationId, @RequestParam(value="level") Integer level){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailService.findTitleParseList(situationId, level)), null, HttpStatus.OK);
    }



}
