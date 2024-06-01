public class Cylinder extends Shape {

  private double radius;
  private double height;

  public Cylinder(double radius, double height) {
    this.radius = radius;
    this.height = height;
  }

  @Override
  public double surfaceArea() {
    // A = 2 * PI * r * h + 2 * PI * r^2
    return 2.0 * Math.PI * this.radius * this.height + 2.0 * Math.PI * Math.pow(this.radius, 2);
  }

  @Override
  public double volume() {
    // V = PI * r^2 * h
    return Math.PI * Math.pow(this.radius, 2) * this.height;
  }

  @Override
  public String toString() {
    return String.format(
        "This cylinder has a surface area of %.2f and volume of %.2f.",
        this.surfaceArea(), this.volume());
  }
}
