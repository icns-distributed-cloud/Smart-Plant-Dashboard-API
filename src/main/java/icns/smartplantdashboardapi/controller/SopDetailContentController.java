package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.domain.User;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sopDetail.SopDetailContentRequest;
import icns.smartplantdashboardapi.repository.UserRepository;
import icns.smartplantdashboardapi.service.SopDetailContentService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"e-SOP 디테일 콘텐츠 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SopDetailContentController {

    private final SopDetailContentService sopDetailContentService;
    private final UserRepository userRepository;


    @PostMapping("/sop-detail/content")
    public ResponseEntity saveContent(@RequestBody SopDetailContentRequest sopDetailContentRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, sopDetailContentService.save(sopDetailContentRequest)),null, HttpStatus.OK);
    }

    @PutMapping("/sop-detail/content/{contentId}")
    public ResponseEntity updateContent(@PathVariable(value="contentId") Long contentId, @RequestBody SopDetailContentRequest sopDetailContentRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailContentService.update(contentId, sopDetailContentRequest)),null, HttpStatus.OK);
    }

    @GetMapping("/sop-detail/content/{contentId}")
    public ResponseEntity findContent(@PathVariable(value="contentId") Long contentId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailContentService.find(contentId)),null, HttpStatus.OK);
    }

    @GetMapping("/sop-detail/content")
    public ResponseEntity findAllContent(@RequestParam(value="titleId") Long titleId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailContentService.findAll(titleId)),null, HttpStatus.OK);
    }

    @DeleteMapping("/sop-detail/content/{contentId}")
    public ResponseEntity deleteContent(@PathVariable(value="contentId") Long contentId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailContentService.delete(contentId)), null, HttpStatus.OK);
    }

    @PutMapping("/sop-detail/content/complete/{contentId}")
    public ResponseEntity complete( @PathVariable(value="contentId") Long contentId){ //@AuthenticationPrincipal UserDetails userDetails,
        //User user = userRepository.findByEmail(userDetails.getUsername()).get();
        //return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailContentService.complete(user, contentId)), null, HttpStatus.OK);
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDetailContentService.complete("관리자", contentId)), null, HttpStatus.OK);
    }

    @PutMapping("/sop-detail/content/end")
    public ResponseEntity complete(@RequestParam(value="situationId") Long situationId, @RequestParam(value="level") Integer level){
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT, sopDetailContentService.endSop(situationId, level)), null, HttpStatus.NO_CONTENT);
    }
}
