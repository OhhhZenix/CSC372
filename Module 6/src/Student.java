public class Student {

    private final int rollNumber;
    private final String name;
    private final String address;

    public Student(int rollNumber, String name, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
    }

    public int getRollNumber() {
        return this.rollNumber;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Roll Number: %s, Name: %s, Address: %s", this.rollNumber, this.name, this.address);
    }
}
