package trans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int id;
    private Employee employee;
    private Driver driver;
    private Vehicle vehicle;
    private LocalDate date;
    private LocalTime pickupTime;
    private LocalTime dropoffTime;

    // Constructors, getters, and setters

    public Booking() {
    }

    public Booking(int id, Employee employee, Driver driver, Vehicle vehicle, LocalDate date, LocalTime pickupTime, LocalTime dropoffTime) {
        this.id = id;
        this.employee = employee;
        this.driver = driver;
        this.vehicle = vehicle;
        this.date = date;
        this.pickupTime = pickupTime;
        this.dropoffTime = dropoffTime;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalTime getDropoffTime() {
        return dropoffTime;
    }

    public void setDropoffTime(LocalTime dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    // toString method

    
}
