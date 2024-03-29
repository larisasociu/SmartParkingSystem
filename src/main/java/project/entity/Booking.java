package project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate reservationDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

    @OneToOne(cascade = CascadeType.ALL)
    private ParkingSlot parkingSlot;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    private String parkingName;

    public Booking(LocalDate reservationDate, LocalTime startTime, LocalTime endTime, ParkingSlot parkingSlot, Vehicle vehicle, String parkingName) {
        this.reservationDate = reservationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
        this.parkingName = parkingName;
    }
}
