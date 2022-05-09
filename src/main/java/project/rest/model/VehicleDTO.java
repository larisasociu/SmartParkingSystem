package project.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.entity.Booking;
import project.entity.VehicleType;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDTO {

    private Long id;

    private String vehicleNumber;

    private VehicleType vehicleType;

    private Booking booking;

    public VehicleDTO(Long id, String vehicleNumber, VehicleType vehicleType, Booking booking) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.booking = booking;
    }
}
