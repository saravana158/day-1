package trans;

public class Vehicle {
    private int id;
    private String name;
    private String number;
    private int capacity;

    // Constructors, getters, and setters

    public Vehicle() {
    }

    public Vehicle(int id, String name, String number, int capacity) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.capacity = capacity;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    
}
