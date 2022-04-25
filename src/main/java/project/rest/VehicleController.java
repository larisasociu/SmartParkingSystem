package project.rest;

import project.entity.Vehicle;
import project.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping(value = "/vehicle")
    public void saveVehicle(@RequestBody Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @GetMapping(value = "/vehicle/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
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
