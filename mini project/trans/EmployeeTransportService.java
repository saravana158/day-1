package trans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTransportService {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/empTrans";
//	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/empTrans?useSSL=false&requireSSL=false";

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "yogesh_bec_m";

    // Create a connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Create
    public void addDriver(Driver driver) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO drivers (driver_name, contact_number, email) VALUES (?, ?, ?)")) {
            pstmt.setString(1, driver.getName());
            pstmt.setString(2, driver.getContactNumber());
            pstmt.setString(3, driver.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO vehicles (vehicle_name, vehicle_number, capacity) VALUES (?, ?, ?)")) {
            pstmt.setString(1, vehicle.getName());
            pstmt.setString(2, vehicle.getNumber());
            pstmt.setInt(3, vehicle.getCapacity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBooking(Booking booking) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO bookings (employee_id, driver_id, vehicle_id, booking_date, pickup_time, dropoff_time) VALUES (?, ?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, booking.getEmployee().getId());
            pstmt.setInt(2, booking.getDriver().getId());
            pstmt.setInt(3, booking.getVehicle().getId());
            pstmt.setDate(4, Date.valueOf(booking.getDate()));
            pstmt.setTime(5, Time.valueOf(booking.getPickupTime()));
            pstmt.setTime(6, Time.valueOf(booking.getDropoffTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO time_slots (slot_start_time, slot_end_time) VALUES (?, ?)")) {
            pstmt.setTime(1, Time.valueOf(timeSlot.getStartTime()));
            pstmt.setTime(2, Time.valueOf(timeSlot.getEndTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM drivers")) {
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setId(rs.getInt("driver_id"));
                driver.setName(rs.getString("driver_name"));
                driver.setContactNumber(rs.getString("contact_number"));
                driver.setEmail(rs.getString("email"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM vehicles")) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("vehicle_id"));
                vehicle.setName(rs.getString("vehicle_name"));
                vehicle.setNumber(rs.getString("vehicle_number"));
                vehicle.setCapacity(rs.getInt("capacity"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bookings")) {
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("booking_id"));
                // Fetch the employee, driver, and vehicle details from their respective tables
                Employee employee = getEmployeeById(rs.getInt("employee_id"));
                Driver driver = getDriverById(rs.getInt("driver_id"));
                Vehicle vehicle = getVehicleById(rs.getInt("vehicle_id"));
                booking.setEmployee(employee);
                booking.setDriver(driver);
                booking.setVehicle(vehicle);
                booking.setDate(rs.getDate("booking_date").toLocalDate());
                booking.setPickupTime(rs.getTime("pickup_time").toLocalTime());
                booking.setDropoffTime(rs.getTime("dropoff_time").toLocalTime());
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public List<TimeSlot> getAllTimeSlots() {
        List<TimeSlot> timeSlots = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM time_slots")) {
            while (rs.next()) {
                TimeSlot timeSlot = new TimeSlot();
                timeSlot.setId(rs.getInt("timeslot_id"));
                timeSlot.setStartTime(rs.getTime("slot_start_time").toLocalTime());
                timeSlot.setEndTime(rs.getTime("slot_end_time").toLocalTime());
                timeSlots.add(timeSlot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeSlots;
    }

    // Helper methods to fetch individual records by ID
    private Employee getEmployeeById(int employeeId) {
        // Implement code to fetch the employee from the database using the employeeId
        // and return the Employee object
        return null; // Placeholder, you need to implement this method
    }

    private Driver getDriverById(int driverId) {
        // Implement code to fetch the driver from the database using the driverId
        // and return the Driver object
        return null; // Placeholder, you need to implement this method
    }

    private Vehicle getVehicleById(int vehicleId) {
        // Implement code to fetch the vehicle from the database using the vehicleId
        // and return the Vehicle object
        return null; // Placeholder, you need to implement this method
    }

    // Update
    public void updateDriver(Driver driver) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE drivers SET driver_name = ?, contact_number = ?, email = ? WHERE driver_id = ?")) {
            pstmt.setString(1, driver.getName());
            pstmt.setString(2, driver.getContactNumber());
            pstmt.setString(3, driver.getEmail());
            pstmt.setInt(4, driver.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVehicle(Vehicle vehicle) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE vehicles SET vehicle_name = ?, vehicle_number = ?, capacity = ? WHERE vehicle_id = ?")) {
            pstmt.setString(1, vehicle.getName());
            pstmt.setString(2, vehicle.getNumber());
            pstmt.setInt(3, vehicle.getCapacity());
            pstmt.setInt(4, vehicle.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBooking(Booking booking) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE bookings SET employee_id = ?, driver_id = ?, vehicle_id = ?, booking_date = ?, pickup_time = ?, dropoff_time = ? WHERE booking_id = ?")) {
            pstmt.setInt(1, booking.getEmployee().getId());
            pstmt.setInt(2, booking.getDriver().getId());
            pstmt.setInt(3, booking.getVehicle().getId());
            pstmt.setDate(4, Date.valueOf(booking.getDate()));
            pstmt.setTime(5, Time.valueOf(booking.getPickupTime()));
            pstmt.setTime(6, Time.valueOf(booking.getDropoffTime()));
            pstmt.setInt(7, booking.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTimeSlot(TimeSlot timeSlot) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE time_slots SET slot_start_time = ?, slot_end_time = ? WHERE timeslot_id = ?")) {
            pstmt.setTime(1, Time.valueOf(timeSlot.getStartTime()));
            pstmt.setTime(2, Time.valueOf(timeSlot.getEndTime()));
            pstmt.setInt(3, timeSlot.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteDriver(int driverId) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM drivers WHERE driver_id = ?")) {
            pstmt.setInt(1, driverId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(int vehicleId) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM vehicles WHERE vehicle_id = ?")) {
            pstmt.setInt(1, vehicleId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBooking(int bookingId) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM bookings WHERE booking_id = ?")) {
            pstmt.setInt(1, bookingId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTimeSlot(int timeSlotId) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM time_slots WHERE timeslot_id = ?")) {
            pstmt.setInt(1, timeSlotId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees (employee_name, contact_number, email) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
	            pstmt.setString(1, employee.getName());
	            pstmt.setString(2, employee.getContactNumber());
	            pstmt.setString(3, employee.getEmail());
	            pstmt.executeUpdate();

	            // Retrieve the auto-generated employee ID (if supported by the database)
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int generatedId = generatedKeys.getInt(1);
	                    employee.setId(generatedId); // Set the generated ID in the Employee object
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		  List<Employee> employees = new ArrayList<>();
	        try (Connection conn = getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {
	            while (rs.next()) {
	                Employee employee = new Employee();
	                employee.setId(rs.getInt("employee_id"));
	                employee.setName(rs.getString("employee_name"));
	                employee.setContactNumber(rs.getString("contact_number"));
	                employee.setEmail(rs.getString("email"));
	                employees.add(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employees;
		
	}
}