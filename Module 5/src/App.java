import java.util.Arrays;
import java.util.Scanner;

public class App {

  private static final int MAX_RECURSION = 5;

  public static double getInput(Scanner scanner, String prompt) {
    try {
      System.out.println(prompt);
      return Double.parseDouble(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Invalid input. Try again!");
      return getInput(scanner, prompt);
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
        inputs[i] = getInput(scanner, String.format("Entry %s - Enter a number.", (i + 1)));
      }
    }

    double product = calculateInput(inputs, 0); // index is the starting point.
    System.out.println(String.format("The product of the numbers %s is %,.2f.", Arrays.toString(inputs), product));
  }
}
