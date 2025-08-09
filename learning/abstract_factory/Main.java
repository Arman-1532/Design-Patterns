package learning.abstract_factory;

import learning.abstract_factory.factory.*;
import learning.abstract_factory.shape.Shape;
import learning.abstract_factory.color.Color;

public class Main {
    public static void main(String[] args) {
        AbstractFacotry factory1 = FactoryProducer.getFactory("shape");
        Shape shape1 = (Shape) factory1.getShape("circle");
        shape1.print();

        AbstractFacotry factory2 = FactoryProducer.getFactory("color");
        Color shape2 = (Color) factory2.getColor("red");
        shape2.print();
    }
}
