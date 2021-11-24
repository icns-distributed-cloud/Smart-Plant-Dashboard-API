package icns.smartplantdashboardapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SopCheckLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private String user;

    @Column
    private String situation;

    @Column
    private Integer level;

    @Column
    private LocalDateTime createdAt;


    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }

}
