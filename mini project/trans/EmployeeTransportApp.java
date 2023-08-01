package trans;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class EmployeeTransportApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeTransportService transportService = new EmployeeTransportService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Employee Transport Service =====");
            System.out.println("1. Add Driver");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Add Employee");
            System.out.println("4. Add Booking");
            System.out.println("5. Add Time Slot");
            System.out.println("6. View Bookings");
            System.out.println("7. Manage Time Slots");
            System.out.println("8. update Driver");
            System.out.println("9. delete Driver");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addDriver();
                    break;
                case 2:
                    addVehicle();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    addBooking();
                    break;
                case 5:
                    addTimeSlot();
                    break;
                case 6:
                    viewBookings();
                    break;
                case 7:
                    manageTimeSlots();
                    break;
                case 8:
                	updateDriver();
                	break;
                case 9:
                	deleteDriver();
                	break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addDriver() {
        System.out.println("===== Add Driver =====");
        System.out.print("Enter driver name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Driver driver = new Driver();
        driver.setName(name);
        driver.setContactNumber(contactNumber);
        driver.setEmail(email);

        transportService.addDriver(driver);
        System.out.println("Driver added successfully!");
    }

    private static void addVehicle() {
        System.out.println("===== Add Vehicle =====");
        System.out.print("Enter vehicle name: ");
        String name = scanner.nextLine();
        System.out.print("Enter vehicle number: ");
        String number = scanner.nextLine();
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Vehicle vehicle = new Vehicle();
        vehicle.setName(name);
        vehicle.setNumber(number);
        vehicle.setCapacity(capacity);

        transportService.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    private static void addEmployee() {
        System.out.println("===== Add Employee =====");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Employee employee = new Employee();
        employee.setName(name);
        employee.setContactNumber(contactNumber);
        employee.setEmail(email);

        transportService.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private static void addBooking() {
        System.out.println("===== Add Booking =====");
        // Fetch the list of employees, drivers, and vehicles from the service
        List<Employee> employees = transportService.getAllEmployees();
        List<Driver> drivers = transportService.getAllDrivers();
        List<Vehicle> vehicles = transportService.getAllVehicles();

        // Display the available employees, drivers, and vehicles for the user to choose from
        System.out.println("Available Employees:");
        displayEmployees(employees);
        System.out.println("Available Drivers:");
        displayDrivers(drivers);
        System.out.println("Available Vehicles:");
        displayVehicles(vehicles);

        System.out.print("Select Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Select Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Select Vehicle ID: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter booking date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate bookingDate = LocalDate.parse(dateStr);
        System.out.print("Enter pickup time (HH:mm:ss): ");
        String pickupTimeStr = scanner.nextLine();
        LocalTime pickupTime = LocalTime.parse(pickupTimeStr);
        System.out.print("Enter dropoff time (HH:mm:ss): ");
        String dropoffTimeStr = scanner.nextLine();
        LocalTime dropoffTime = LocalTime.parse(dropoffTimeStr);

        Employee employee = findEmployeeById(employees, employeeId);
        Driver driver = findDriverById(drivers, driverId);
        Vehicle vehicle = findVehicleById(vehicles, vehicleId);

        Booking booking = new Booking();
        booking.setEmployee(employee);
        booking.setDriver(driver);
        booking.setVehicle(vehicle);
        booking.setDate(bookingDate);
        booking.setPickupTime(pickupTime);
        booking.setDropoffTime(dropoffTime);

        transportService.addBooking(booking);
        System.out.println("Booking added successfully!");
    }

    private static void addTimeSlot() {
        System.out.println("===== Add Time Slot =====");
        System.out.print("Enter start time (HH:mm:ss): ");
        String startTimeStr = scanner.nextLine();
        LocalTime startTime = LocalTime.parse(startTimeStr);
        System.out.print("Enter end time (HH:mm:ss): ");
        String endTimeStr = scanner.nextLine();
        LocalTime endTime = LocalTime.parse(endTimeStr);

        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);

        transportService.addTimeSlot(timeSlot);
        System.out.println("Time Slot added successfully!");
    }

    private static void viewBookings() {
        System.out.println("===== View Bookings =====");
        // Fetch and display all bookings from the service
        List<Booking> bookings = transportService.getAllBookings();
        displayBookings(bookings);
    }

    private static void manageTimeSlots() {
        System.out.println("===== Manage Time Slots =====");
        // Fetch and display all time slots from the service
        List<TimeSlot> timeSlots = transportService.getAllTimeSlots();
        displayTimeSlots(timeSlots);
    }

    // Helper methods to display lists of entities
    private static void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getId() + ". " + employee.getName());
        }
    }

    private static void displayDrivers(List<Driver> drivers) {
        for (Driver driver : drivers) {
            System.out.println(driver.getId() + ". " + driver.getName());
        }
    }

    private static void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getId() + ". " + vehicle.getName() + " (" + vehicle.getNumber() + ")");
        }
    }

    private static void displayBookings(List<Booking> bookings) {
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getId());
            System.out.println("Employee: " + booking.getEmployee().getName());
            System.out.println("Driver: " + booking.getDriver().getName());
            System.out.println("Vehicle: " + booking.getVehicle().getName());
            System.out.println("Date: " + booking.getDate());
            System.out.println("Pickup Time: " + booking.getPickupTime());
            System.out.println("Dropoff Time: " + booking.getDropoffTime());
            System.out.println("=====================================");
        }
    }

    private static void displayTimeSlots(List<TimeSlot> timeSlots) {
        for (TimeSlot timeSlot : timeSlots) {
            System.out.println("Time Slot ID: " + timeSlot.getId());
            System.out.println("Start Time: " + timeSlot.getStartTime());
            System.out.println("End Time: " + timeSlot.getEndTime());
            System.out.println("=====================================");
        }
    }

    // Helper methods to find entities by ID
    private static Employee findEmployeeById(List<Employee> employees, int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    private static Driver findDriverById(List<Driver> drivers, int driverId) {
        for (Driver driver : drivers) {
            if (driver.getId() == driverId) {
                return driver;
            }
        }
        return null;
    }

    private static Vehicle findVehicleById(List<Vehicle> vehicles, int vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }
    
    private static void updateDriver() {
        System.out.println("===== Update Driver Details =====");
        // Display the available drivers for the user to choose from
        List<Driver> drivers = transportService.getAllDrivers();
        displayDrivers(drivers);

        System.out.print("Select Driver ID to update: ");
        int driverId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Driver driver = findDriverById(drivers, driverId);
        if (driver != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new contact number: ");
            String newContactNumber = scanner.nextLine();
            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();

            driver.setName(newName);
            driver.setContactNumber(newContactNumber);
            driver.setEmail(newEmail);

            transportService.updateDriver(driver);
            System.out.println("Driver details updated successfully!");
        } else {
            System.out.println("Driver with ID " + driverId + " not found.");
        }
    }
    private static void deleteDriver() {
        System.out.println("===== Delete Driver =====");
        // Display the available drivers for the user to choose from
        List<Driver> drivers = transportService.getAllDrivers();
        displayDrivers(drivers);

        System.out.print("Select Driver ID to delete: ");
        int driverId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        transportService.deleteDriver(driverId);
        System.out.println("Driver deleted successfully!");
    }
}
