package project.rest;

import project.entity.Booking;
import project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping(value = "/booking")
    public void saveBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
    }

    @GetMapping(value = "/booking/all")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping(value = "/booking/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingRepository.findById(id);
    }

    @DeleteMapping(value = "/booking/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }

    @PutMapping(value = "/booking/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking newBooking) {
        Booking booking = bookingRepository.findById(id).get();
        if (newBooking.getEndTime() != null) {
            booking.setEndTime(newBooking.getEndTime());
        }
        if (newBooking.getStartTime() != null) {
            booking.setStartTime(newBooking.getStartTime());
        }
        if (newBooking.getReservationDate() != null) {
            booking.setReservationDate(newBooking.getReservationDate());
        }
        return bookingRepository.save(booking);
    }
}
