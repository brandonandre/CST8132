public class X {
    int x;
    public X(){
        initialize();
        printHi();
    }
    public void printHi(){
        System.out.print(" X, with x = " + x);
    }
    public void initialize(){
        x = 3;
    }
}
