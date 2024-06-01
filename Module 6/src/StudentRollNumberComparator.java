import java.util.Comparator;

public class StudentRollNumberComparator implements Comparator<Student> {

    @Override
    public int compare(Student left, Student right) {
        return left.getRollNumber() - right.getRollNumber();
    }
}
