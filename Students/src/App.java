public class App {

    public static void main(String[] args) {
        StudentArray studentArray = new StudentArray();
        studentArray.add(new Student(101, "John", "123 Street, City"));
        studentArray.add(new Student(133, "Alice", "456 Avenue, Town"));
        studentArray.add(new Student(143, "Bob", "789 Road, Village"));
        studentArray.add(new Student(103, "Charlie", "321 Lane, County"));
        studentArray.add(new Student(104, "David", "654 Boulevard, Country"));
        studentArray.add(new Student(108, "Emily", "987 Drive, State"));
        studentArray.add(new Student(110, "Fiona", "147 Park, Province"));
        studentArray.add(new Student(111, "George", "258 Lane, District"));
        studentArray.add(new Student(139, "Hannah", "369 Circle, Region"));
        studentArray.add(new Student(120, "Ian", "951 Square, Continent"));

        System.out.println("Data as it is:");
        studentArray.printAll();

        System.out.println("Data sorted by roll numbers:");
        studentArray.sortByRollNumbers();
        studentArray.printAll();

        System.out.println("Data sorted by names:");
        studentArray.sortByNames();
        studentArray.printAll();
    }
}
