import java.util.function.ToDoubleFunction;

public class FunctionalProgramming {
/*
Creates a function to apply to a Triangle t, that calculates, sets, and returns the height of t.
The Triangle class is below for reference.
*/
  public static ToDoubleFunction<Triangle> f = t -> {
       double area = ((double)t.base*(double)t.height)/2;
       t.setArea(area);
       return t.getArea();
       };
}

/*
public class Triangle {
  public final int height;
  public final int base;
  private double area;
  public void setArea(double a) {
    area = a;
  }
  public double getArea() {
    return area;
  }
}
*/