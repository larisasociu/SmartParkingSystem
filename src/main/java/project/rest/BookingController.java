package project.rest;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.entity.Booking;
import project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

//    @GetMapping(value = "/booking/all")
//    public String getAllBookings(Model model) {
//        model.addAttribute("bookings", bookingRepository.findAll());
//        return "all-bookings";
//    }
//
//    @GetMapping(value = "/booking/save")
//    public String saveBookingForm(Model model) {
//        model.addAttribute("booking", new Booking());
//        return "add-bookings";
//    }
//
//    @PostMapping(value = "/booking/save")
//    public String saveBooking(@ModelAttribute("booking") @RequestBody Booking booking, RedirectAttributes redirectAttributes) {
//        bookingRepository.save(booking);
//        redirectAttributes.addFlashAttribute("message", "The booking has been saved successfully.");
//        return "redirect:/booking/save";
//    }

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
}
