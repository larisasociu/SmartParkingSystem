package project.rest;

import project.entity.ParkingSlot;
import project.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ParkingSlotController {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @PostMapping(value = "/slot")
    public void saveSlot(@RequestBody ParkingSlot parkingSlot) {
        parkingSlotRepository.save(parkingSlot);
    }

    @GetMapping(value = "/slot/all")
    public List<ParkingSlot> getAllSlots() {
        return parkingSlotRepository.findAll();
    }

    @GetMapping(value = "/slot/{id}")
    public Optional<ParkingSlot> getParkingSlotById(@PathVariable Long id) {
        return parkingSlotRepository.findById(id);
    }

    @DeleteMapping(value = "/slot/{id}")
    public void deleteSlot(@PathVariable Long id) {
        parkingSlotRepository.deleteById(id);
    }
}
