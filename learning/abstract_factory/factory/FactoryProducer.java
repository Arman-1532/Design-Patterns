package learning.abstract_factory.factory;

public class FactoryProducer {
    public static AbstractFacotry getFactory(String choice){
        if(choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }
        else if(choice.equalsIgnoreCase("color")){
            return new ColorFactory(); 
        }
        return null;
    }
}
