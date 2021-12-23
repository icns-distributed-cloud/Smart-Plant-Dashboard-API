package icns.smartplantdashboardapi.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String sender;

    @Column
    private String text;

    @Column
    private String receiver;

    @Column
    private boolean send;

    @Column
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }
}
