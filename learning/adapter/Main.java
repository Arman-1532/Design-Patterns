package learning.adapter;

public class Main {
    public static void main(String[] args) {
        RoundHole rh = new RoundHole(5);
        RoundPeg rp = new RoundPeg(5);

        if(rh.fits(rp)){
            System.out.println("roundpeg fits in hole");
        }
        SquarePeg sp = new SquarePeg(6);
        Adapter sqaAdapter = new Adapter(sp);
        if(rh.fits(sqaAdapter)){
            System.out.println("square fits in circle");
        }
    }

}
