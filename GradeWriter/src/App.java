
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    private final static String QUIT_MSG = "Exiting entry mode...";
    private final static String INVALID_INPUT_MSG = "Invalid input, try again!";

    public static String getStringInput(Scanner scanner, String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }

        String input = scanner.nextLine();
        if (input == null || input.isEmpty()) {
            System.out.println(INVALID_INPUT_MSG);
            return getStringInput(scanner, messages);
        }
        return input;
    }

    public static double getDoubleInput(Scanner scanner, String... messages) {
        try {
            for (String message : messages) {
                System.out.println(message);
            }
            return Double.parseDouble(scanner.nextLine());
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(INVALID_INPUT_MSG);
            return getDoubleInput(scanner, messages);
        }
    }

    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();

        // Data entry
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String name = getStringInput(scanner, "Enter the name of the student or type 'q' to quit.");
                if (name.equalsIgnoreCase("q")) {
                    System.out.println(QUIT_MSG);
                    break;
                }

                String address = getStringInput(scanner, "Enter the address of the student or type 'q' to quit.");
                if (address.equalsIgnoreCase("q")) {
                    System.out.println(QUIT_MSG);
                    break;
                }

                double gradePointAverage = getDoubleInput(scanner, "Enter the GPA of the student or type '-1' to quit");
                if (gradePointAverage == -1) {
                    System.out.println(QUIT_MSG);
                    break;
                }

                Student student = new Student(name, address, gradePointAverage);
                System.out.println(String.format("Entry added - %s", student.toString()));
                students.add(student);
            }
        }

        if (students.isEmpty()) {
            System.out.println("Warning: the data entries are empty!");
        }

        // Sort the list by ascending names
        Collections.sort(students, new StudentNameComparator());

        // Write list to file named "students.txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to students.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}