public class Cone extends Shape {

  private double radius;
  private double height;

  public Cone(double radius, double height) {
    this.radius = radius;
    this.height = height;
  }

  @Override
  public double surfaceArea() {
    // A = PI * r * (r + sqrt(h^2 + r^2))
    return Math.PI
        * this.radius
        * (this.radius + Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.radius, 2)));
  }

  @Override
  public double volume() {
    // V = PI * r^2 * h/3
    return Math.PI * Math.pow(this.radius, 2) * (this.height / 3.0);
  }

  @Override
  public String toString() {
    return String.format(
        "This cone has a surface area of %.2f and volume of %.2f.",
        this.surfaceArea(), this.volume());
  }
}
