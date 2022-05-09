package project.mapper;

import project.entity.Booking;
import project.rest.model.BookingDTO;

public class BookingMapper {

    public static Booking fromDtoToEntity(BookingDTO bookingDTO) {
        return new Booking(bookingDTO.getReservationDate(), bookingDTO.getStartTime(), bookingDTO.getEndTime(),
                bookingDTO.getParkingSlot(), bookingDTO.getVehicle(), bookingDTO.getParkingName());
    }

    public static BookingDTO fromEntityToDto(Booking booking) {
        return new BookingDTO(booking.getId(), booking.getReservationDate(), booking.getStartTime(),
                booking.getEndTime(),
                booking.getParkingSlot(), booking.getVehicle());
    }
}
