package project.rest;

import project.entity.Booking;
import project.entity.Vehicle;
import project.mapper.BookingMapper;
import project.mapper.VehicleMapper;
import project.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.rest.model.BookingDTO;
import project.rest.model.VehicleDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping(value = "/vehicle")
    public Vehicle saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleRepository.save(VehicleMapper.fromDtoToEntity(vehicleDTO));
    }

    @GetMapping(value = "/vehicle/all")
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(VehicleMapper::fromEntityToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/vehicle/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleRepository.findById(id);
    }

    @DeleteMapping(value = "/vehicle/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
    }
}
