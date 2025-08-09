package learning.adapter;

public class Adapter extends RoundPeg{
    SquarePeg sp;
    
    public Adapter(SquarePeg sp) {
        this.sp = sp;
    }
    
    public double getRadius(){
        return (Math.sqrt(2) * sp.getWidth()) / 2 ;
    }
}
