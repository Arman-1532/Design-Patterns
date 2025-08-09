package visitor;

public class CircumfirenceCalculatorVisitor implements Visitor {

    @Override
    public void visit(Circle circle) {
        double circumference = (4.0 / 3.0) * Math.PI * Math.pow(circle.getRadius(), 3);
        System.out.println("Circle volume: " + circumference);
    }

    @Override
    public void visit(Triangle triangle) {
        double circumference =  2 * triangle.getBase() + triangle.getHeight();
        System.out.println("Triangle volume: " + circumference);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double circumference = 2 * (rectangle.getWidth() + rectangle.getHeight());
        System.out.println("Rectangle volume: " + circumference);
    }
}
