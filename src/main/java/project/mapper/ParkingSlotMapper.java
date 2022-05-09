package project.mapper;

import project.entity.ParkingSlot;
import project.rest.model.ParkingSlotDTO;

public class ParkingSlotMapper {

    public static ParkingSlot fromDtoToEntity(ParkingSlotDTO parkingSlotDTO) {
        return new ParkingSlot(parkingSlotDTO.getSlotNumber(), parkingSlotDTO.isAvailable(),
                parkingSlotDTO.getBooking());
    }

    public static ParkingSlotDTO fromEntityToDto(ParkingSlot parkingSlot) {
        return new ParkingSlotDTO(parkingSlot.getId(), parkingSlot.getSlotNumber(), parkingSlot.isAvailable(),
                parkingSlot.getBooking());
    }
}
