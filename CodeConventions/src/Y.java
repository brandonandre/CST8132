
public class Y extends X{
    //@Override
    public void initialize(){
        x = 99;
    }
    //@Override
    public void printHi(){
        System.out.print(" Y, with x = " + super.x);
    }
}
