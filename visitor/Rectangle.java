package visitor;

public class Rectangle implements Shape {
    private double w, l;

    public Rectangle(double width, double length) {
        this.w = width;
        this.l = length;
    }

    public double getWidth() {
        return w;
    }

    public double getHeight() {
        return l;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
