public class SimpleSong {
   public static void main(String args[]) {
       Guitar guitar = new Guitar();

           guitar.pluck(3);
           pause(2);
           guitar.turn(3,2);
           guitar.pluck(3);
           pause(2);
           guitar.turn(3,-2);
           guitar.pluck(3);
           pause(2);
           guitar.pluck(6);
           pause(2);
   }
   private static void pause(int seconds) {
      try {
          Thread.sleep(seconds * 1000);
      } catch (InterruptedException e) {
         // ignore for now
      }
   }
}
