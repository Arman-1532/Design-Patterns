package visitor;

public class Triangle implements Shape {
    private double b, h;

    public Triangle(double base, double height) {
        this.b = base;
        this.h = height;
    }

    public double getBase() {
        return b;
    }

    public double getHeight() {
        return h;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
