package project.rest;

import project.entity.Booking;
import project.entity.ParkingSlot;
import project.mapper.BookingMapper;
import project.mapper.ParkingSlotMapper;
import project.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.rest.model.BookingDTO;
import project.rest.model.ParkingSlotDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ParkingSlotController {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @PostMapping(value = "/slot")
    public ParkingSlot saveSlot(@RequestBody ParkingSlotDTO parkingSlotDTO) {
        return parkingSlotRepository.save(ParkingSlotMapper.fromDtoToEntity(parkingSlotDTO));
    }

    @GetMapping(value = "/slot/all")
    public List<ParkingSlotDTO> getAllSlots() {
        return parkingSlotRepository.findAll().stream().map(ParkingSlotMapper::fromEntityToDto).collect(Collectors.toList());
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
