package project.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.entity.ParkingSlot;
import project.entity.Vehicle;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {

    private Long id;

    private LocalDate reservationDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private ParkingSlot parkingSlot;

    private Vehicle vehicle;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parkingName;

    public BookingDTO(Long id, LocalDate reservationDate, LocalTime startTime, LocalTime endTime, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }
}
