import java.util.ArrayList;

public class ShapeArray {

  private ArrayList<Shape> shapes;

  public ShapeArray() {
    this.shapes = new ArrayList<>();
  }

  // allows ease of adding new shape to the array
  public void add(Shape shape) {
    this.shapes.add(shape);
  }

  // prints all shapes toString method
  public void printAll() {
    for (int i = 0; i < this.shapes.size(); i++) {
      System.out.println(String.format("Index %s - %s", i, this.shapes.get(i).toString()));
    }
  }
}
