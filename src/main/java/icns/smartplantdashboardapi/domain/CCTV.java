package icns.smartplantdashboardapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CCTV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long cctvId;

    @Column(nullable = true)
    private String userId;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)  //나중에 unique = true
    private String streamURL;

    @Column(nullable = true)
    private String websocketURL;

    @Column(nullable = true)
    private String cctvLocation;

    @Override
    public String toString(){
        return "CCTV{" +
                "cctvId=" + cctvId +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", streamURL='" + streamURL + '\'' +
                ", websocketURL=" + websocketURL + '\'' +
                ", cctvLocation=" + cctvLocation +
                '}';
    }

}
