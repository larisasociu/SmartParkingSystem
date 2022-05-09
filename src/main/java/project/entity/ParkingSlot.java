package project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
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

    public ParkingSlot(String slotNumber, boolean available, Booking booking) {
        this.slotNumber = slotNumber;
        this.available = available;
        this.booking = booking;
    }
}
