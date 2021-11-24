package icns.smartplantdashboardapi.dto.auth;

import icns.smartplantdashboardapi.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String email;

    private Long id;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.id = user.getId();
    }


}
