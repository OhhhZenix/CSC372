public class Student {

    private final String name;
    private final String address;
    private final double gradePointAverage;

    public Student(String name, String address, double gradePointAverage) {
        this.name = name;
        this.address = address;
        this.gradePointAverage = gradePointAverage;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public double getGradePointAverage() {
        return this.gradePointAverage;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Address: " + this.address + ", GPA: " + this.gradePointAverage;
    }
}
