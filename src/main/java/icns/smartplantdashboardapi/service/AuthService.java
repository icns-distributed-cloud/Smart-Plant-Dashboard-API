package icns.smartplantdashboardapi.service;

import icns.smartplantdashboardapi.advice.exception.DuplicateException;
import icns.smartplantdashboardapi.advice.exception.UnAuthorizedException;
import icns.smartplantdashboardapi.config.details.UserDetailsImpl;
import icns.smartplantdashboardapi.config.jwt.JwtUtils;
import icns.smartplantdashboardapi.domain.User;
import icns.smartplantdashboardapi.dto.auth.JwtResponse;
import icns.smartplantdashboardapi.dto.auth.LoginRequest;
import icns.smartplantdashboardapi.dto.auth.SignupRequest;
import icns.smartplantdashboardapi.dto.auth.UserResponse;
import icns.smartplantdashboardapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Transactional
    public Long register(SignupRequest signupRequest){
        userRepository.findByEmail(signupRequest.getEmail()).ifPresent(m ->{
            throw new DuplicateException();
        });
        User user = User.builder()
                .email(signupRequest.getEmail())
                .password(encoder.encode(signupRequest.getPassword()))
                .build();

        User saved = userRepository.save(user);
        return saved.getId();
    }

    @Transactional
    public JwtResponse login(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new JwtResponse(jwt, userDetails.getId(),userDetails.getUsername());

    }

    public UserResponse checkAuthState(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if(principal == "anonymousUser"){
            throw new UnAuthorizedException();
        }
        UserDetails userDetails = (UserDetails) principal;
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        return new UserResponse(user);

    }
}
