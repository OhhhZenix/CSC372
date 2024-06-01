public class Sphere extends Shape {

  private double radius;

  public Sphere(double radius) {
    this.radius = radius;
  }

  @Override
  public double surfaceArea() {
    // A = 4 * pi * r^2
    return (4) * (Math.PI) * (Math.pow(this.radius, 2));
  }

  @Override
  public double volume() {
    // V = 4/3 * pi * r^3
    return (4.0 / 3.0) * (Math.PI) * (Math.pow(this.radius, 3));
  }

  @Override
  public String toString() {
    return String.format(
        "This sphere has a surface area of %.2f and volume of %.2f.",
        this.surfaceArea(), this.volume());
  }
}
