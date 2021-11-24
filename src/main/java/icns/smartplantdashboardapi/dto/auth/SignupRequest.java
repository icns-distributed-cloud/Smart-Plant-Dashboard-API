package icns.smartplantdashboardapi.dto.auth;

import icns.smartplantdashboardapi.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class SignupRequest {

    private String email;

    private String password;

    private String phone;

    private String name;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .phone(phone)
                .name(name)
                .build();
    }

}
