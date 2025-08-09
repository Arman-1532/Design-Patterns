interface Shape {
    void accept(ShapeVisitor visitor);
}

interface ShapeVisitor {
    void visitCircle(Circle c);
    void visitTriangle(Triangle t);
    void visitRectangle(Rectangle r);
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}

class Triangle implements Shape {
    private double base, height;
    private double a, b, c;

    public Triangle(double base, double height, double a, double b, double c) {
        this.base = base;
        this.height = height;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double getSideA() {
        return a;
    }

    public double getSideB() {
        return b;
    }

    public double getSideC() {
        return c;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitTriangle(this);
    }
}

class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitRectangle(this);
    }
}

class AreaCalculatorVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle c) {
        double area = Math.PI * c.getRadius() * c.getRadius();
        System.out.println("Area of Circle: " + area);
    }

    @Override
    public void visitTriangle(Triangle t) {
        double area = 0.5 * t.getBase() * t.getHeight();
        System.out.println("Area of Triangle: " + area);
    }

    @Override
    public void visitRectangle(Rectangle r) {
        double area = r.getLength() * r.getWidth();
        System.out.println("Area of Rectangle: " + area);
    }
}

class CircumferenceCalculatorVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle c) {
        double circumference = 2 * Math.PI * c.getRadius();
        System.out.println("Circumference of Circle: " + circumference);
    }

    @Override
    public void visitTriangle(Triangle t) {
        double perimeter = t.getSideA() + t.getSideB() + t.getSideC();
        System.out.println("Perimeter of Triangle: " + perimeter);
    }

    @Override
    public void visitRectangle(Rectangle r) {
        double perimeter = 2 * (r.getLength() + r.getWidth());
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }
}

public class ShapeVisitorDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Triangle(3, 4, 3, 4, 5),
            new Rectangle(4, 6)
        };

        ShapeVisitor areaVisitor = new AreaCalculatorVisitor();
        ShapeVisitor circumferenceVisitor = new CircumferenceCalculatorVisitor();

        System.out.println("=== Areas ===");
        for (Shape shape : shapes) {
            shape.accept(areaVisitor);
        }

        System.out.println("\n=== Perimeters / Circumferences ===");
        for (Shape shape : shapes) {
            shape.accept(circumferenceVisitor);
        }
    }
}
