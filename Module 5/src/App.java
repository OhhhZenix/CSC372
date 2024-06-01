import java.util.Scanner;

public class App {

  private static final int MAX_RECURSION = 5;

  public static double getInput(Scanner scanner) {
    try {
      System.out.println("Enter a number.");
      return Double.parseDouble(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Invalid input. Try again!");
      return getInput(scanner);
    }
  }

  public static double calculateInput(double[] numbers, int index) {
    if (index == numbers.length - 1) { // exit
      return numbers[index];
    }
    return numbers[index] * calculateInput(numbers, index + 1); // repeat
  }

  public static void main(String[] args) {
    double[] inputs = new double[MAX_RECURSION];
    try (Scanner scanner = new Scanner(System.in)) {
      for (int i = 0; i < MAX_RECURSION; i++) {
        inputs[i] = getInput(scanner);
      }
    }
    double product = calculateInput(inputs, 0); // index is the starting point.
    System.out.println(String.format("The product of the five numbers is: %.2f", product));
  }
}
