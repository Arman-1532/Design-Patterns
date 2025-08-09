package learning.abstract_factory.factory;

import learning.abstract_factory.shape.Shape;
import learning.abstract_factory.color.Color;

public interface AbstractFacotry {
    Shape getShape(String type);
    Color getColor(String color);
}
