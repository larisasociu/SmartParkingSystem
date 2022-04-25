package project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class ParkingSlot {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String slotNumber;

    private boolean available;

    @OneToOne(mappedBy = "parkingSlot", cascade = CascadeType.ALL)
    @JsonIgnore
    private Booking booking;

}
