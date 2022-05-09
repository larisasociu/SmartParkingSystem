package project.mapper;

import project.entity.Vehicle;
import project.rest.model.VehicleDTO;

public class VehicleMapper {

    public static Vehicle fromDtoToEntity(VehicleDTO vehicleDTO) {
        return new Vehicle(vehicleDTO.getVehicleNumber(), vehicleDTO.getVehicleType(), vehicleDTO.getBooking());
    }

    public static VehicleDTO fromEntityToDto(Vehicle vehicle) {
        return new VehicleDTO(vehicle.getId(), vehicle.getVehicleNumber(), vehicle.getVehicleType(),
                vehicle.getBooking());
    }
}
