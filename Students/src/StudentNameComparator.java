import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student left, Student right) {
        return left.getName().compareTo(right.getName());
    }
}
