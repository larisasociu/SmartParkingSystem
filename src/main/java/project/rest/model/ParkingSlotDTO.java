package project.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.entity.Booking;

@Getter
@Setter
@NoArgsConstructor
public class ParkingSlotDTO {

    private Long id;

    private String slotNumber;

    private boolean available;

    private Booking booking;

    public ParkingSlotDTO(Long id, String slotNumber, boolean available, Booking booking) {
        this.id = id;
        this.slotNumber = slotNumber;
        this.available = available;
        this.booking = booking;
    }
}
