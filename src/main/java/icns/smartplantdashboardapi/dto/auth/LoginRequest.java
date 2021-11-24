package icns.smartplantdashboardapi.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class LoginRequest {

    private String email;

    @Size
    private String password;
}
