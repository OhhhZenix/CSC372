public class App {

  public static void main(String[] args) {
    // Create the array
    ShapeArray shapeArray = new ShapeArray();
    // Add shapes to the array
    shapeArray.add(new Sphere(1));
    shapeArray.add(new Cylinder(2, 2));
    shapeArray.add(new Cone(2, 2));
    // Output the shapes in the array
    shapeArray.printAll();
  }
}
