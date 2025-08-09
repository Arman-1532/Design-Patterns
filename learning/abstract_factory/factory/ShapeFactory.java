package learning.abstract_factory.factory;

import learning.abstract_factory.shape.Shape;
import learning.abstract_factory.color.Color;
import learning.abstract_factory.shape.Circle;
import learning.abstract_factory.shape.Square;
import learning.abstract_factory.shape.Rectangle;

public class ShapeFactory implements AbstractFacotry{
    public Shape getShape(String type){
        if(type == null){
            return null;
        }
        else if(type.equalsIgnoreCase("circle")){
            return new Circle();
        }
        else if(type.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        else if(type.equalsIgnoreCase("square")){
            return new Square();
        }
        return null;
    }

    public Color getColor(String color){
        return null;
    }
}
