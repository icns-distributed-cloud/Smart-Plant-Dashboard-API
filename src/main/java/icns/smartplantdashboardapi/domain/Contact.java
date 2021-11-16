package icns.smartplantdashboardapi.domain;

import icns.smartplantdashboardapi.dto.contact.ContactRequest;
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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String phone;

    @Column
    private String name;

    @ManyToOne(targetEntity = SensorPos.class, fetch=FetchType.LAZY)
    @JoinColumn(name="sensorpos_id", nullable = false)
    private SensorPos ssPos;

    public Contact update(ContactRequest contactRequest, SensorPos sensorPos){
        this.name = contactRequest.getName();
        this.phone = contactRequest.getPhone();
        this.ssPos = sensorPos;
        return this;
    }

}
