package learning.abstract_factory.factory;

import learning.abstract_factory.shape.Shape;
import learning.abstract_factory.color.Color;
import learning.abstract_factory.color.Black;
import learning.abstract_factory.color.Green;
import learning.abstract_factory.color.Red;

public class ColorFactory implements AbstractFacotry{
    public Shape getShape(String type){
        return null;
    }
    public Color getColor(String color){
        if(color == null){
            return null;
        }
        else if(color.equalsIgnoreCase("red")){
            return new Red();
        }
        else if(color.equalsIgnoreCase("green")){
            return new Green();
        }
        else if(color.equalsIgnoreCase("black")){
            return new Black();
        }
        return null;
    }
}
