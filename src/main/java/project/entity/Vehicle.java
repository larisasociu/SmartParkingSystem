package project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @JsonIgnore
    private Booking booking;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, Booking booking) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.booking = booking;
    }
}
