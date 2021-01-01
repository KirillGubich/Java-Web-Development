package main.java.com.epam.jwd.figure.builder;

public abstract class FigureCriteria {

    private final double perimeter;
    private final double area;
    private final double minPerimeter;
    private final double maxPerimeter;
    private final double minArea;
    private final double maxArea;

    public FigureCriteria(double perimeter, double area, double minPerimeter, double maxPerimeter, double minArea, double maxArea) {
        this.perimeter = perimeter;
        this.area = area;
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getMinPerimeter() {
        return minPerimeter;
    }

    public double getMaxPerimeter() {
        return maxPerimeter;
    }

    public double getMinArea() {
        return minArea;
    }

    public double getMaxArea() {
        return maxArea;
    }
}
