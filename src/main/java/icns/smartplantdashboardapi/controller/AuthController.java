package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.auth.LoginRequest;
import icns.smartplantdashboardapi.dto.auth.SignupRequest;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Api(tags = {"유저인증"})
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/auth/signup")
    public ResponseEntity signUp(@Valid @RequestBody SignupRequest signupRequest){

        return new ResponseEntity(CommonResponse.res(StatusCode.OK,authService.register(signupRequest)), null, HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity logIn(@Valid @RequestBody LoginRequest loginRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,authService.login(loginRequest)), null, HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity<?> loggedIn(){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, authService.checkAuthState()), null, HttpStatus.OK);
    }





}
