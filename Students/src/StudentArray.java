import java.util.ArrayList;
import java.util.Comparator;

public class StudentArray {

    private final ArrayList<Student> students;

    public StudentArray() {
        this.students = new ArrayList<>();
    }

    public void add(Student student) {
        this.students.add(student);
    }

    private void selectionSort(Comparator<? super Student> comparator) {
        int arrayLength = this.students.size();

        for (int i = 0; i < arrayLength - 1; i++) {
            int minimumIndex = i; // base index

            // gets comparative index
            for (int j = i + 1; j < arrayLength; j++) {
                if (comparator.compare(this.students.get(j), this.students.get(minimumIndex)) < 0)
                    minimumIndex = j;
            }

            // Swap elements
            Student temp = this.students.get(minimumIndex);
            this.students.set(minimumIndex, this.students.get(i));
            this.students.set(i, temp);
        }
    }

    public void sortByNames() {
        selectionSort(new StudentNameComparator());
    }

    public void sortByRollNumbers() {
        selectionSort(new StudentRollNumberComparator());
    }

    public void printAll() {
        for (Student student : this.students) {
            System.out.println(student.toString());
        }
    }
}
