package guitar;

public class ImaginePerformance {

  private Guitar guitar;
  private GuitarPlayerLeftHand leftHand;
  private GuitarPlayerRightHand rightHand;

  public ImaginePerformance() {
    guitar = new Guitar();

    rightHand = new RightHand(guitar);
    leftHand = new LeftHand(guitar);
  }

  protected void verse1() {
    leftHand.c();
    rightHand.pluck(3, 5);
    pause(350);
    for (int i = 0; i < 2; i++) {
      rightHand.pluck(4);
      pause(350);
      rightHand.pluck(3);
      pause(350);
    }
    rightHand.pluck(4);
    pause(350);
    leftHand.cmaj7();
    rightHand.pluck(2);
    pause(350);
    rightHand.pluck(4);
    pause(350);
    leftHand.f();
    rightHand.pluck(3, 6);
    pause(350);
    for (int i = 0; i < 2; i++) {
      rightHand.pluck(4);
      pause(350);
      rightHand.pluck(3);
      pause(350);
    }
    rightHand.pluck(4);
    pause(350);
    rightHand.pluck(3);
    pause(175);
    leftHand.hammerOn(3, 3);
    pause(175);
    leftHand.open();
    rightHand.pluck(2);
    pause(350);
  }

  protected void verse2() {
    leftHand.f();
    rightHand.pluck(2, 3, 4);
    pause(350);
    rightHand.pluck(6);
    pause(350);
    rightHand.pluck(2, 3, 4);
    pause(700);
    leftHand.am();
    rightHand.pluck(2, 3, 4);
    pause(350);
    rightHand.pluck(5);
    pause(350);
    rightHand.pluck(2, 3, 4);
    pause(700);
    leftHand.dm7();
    for (int i = 0; i < 2; i++) {
      rightHand.pluck(1, 2, 3);
      pause(350);
      rightHand.pluck(4);
      pause(350);
    }
    leftHand.dm7c();
    for (int i = 0; i < 2; i++) {
      rightHand.pluck(1, 2, 3);
      pause(350);
      rightHand.pluck(5);
      pause(350);
    }
    leftHand.gb();
    for (int i = 0; i < 4; i++) {
      rightHand.pluck(2, 3, 4);
      pause(350);
      rightHand.pluck(5);
      pause(350);
    }
    leftHand.g7();
    rightHand.strum();
    pause(2980);
  }

  protected void chorus() {
    for (int j = 0; j < 3; j++) {
      leftHand.f();
      for (int i = 0; i < 2; i++) {
        rightHand.pluck(2, 3, 4);
        pause(350);
        rightHand.pluck(6);
        pause(350);
      }
      leftHand.g();
      for (int i = 0; i < 2; i++) {
        rightHand.pluck(2, 3, 4);
        pause(350);
        rightHand.pluck(6);
        pause(350);
      }
      leftHand.c();
      for (int i = 0; i < 2; i++) {
        rightHand.pluck(2, 3, 4);
        pause(350);
        rightHand.pluck(5);
        pause(350);
      }
      leftHand.e7();
      for (int i = 0; i < 2; i++) {
        rightHand.pluck(2, 3, 4);
        pause(350);
        rightHand.pluck(6);
        pause(350);
      }
    }
    leftHand.f();
    for (int i = 0; i < 2; i++) {
      rightHand.pluck(2, 3, 4);
      pause(350);
      rightHand.pluck(6);
      pause(350);
    }
    leftHand.g();
    for (int i = 0; i < 2; i++) {
      rightHand.pluck(2, 3, 4);
      pause(350);
      rightHand.pluck(6);
      pause(350);
    }
    leftHand.c();
    rightHand.strum(5);
  }

  protected static void pause(int milliSeconds) {
    try {
      Thread.sleep(milliSeconds);
    } catch (InterruptedException e) {
      // ignore for now
    }
  }

  public static void main(String args[]) {

    ImaginePerformance perform = new ImaginePerformance();

    for (int i = 0; i < 2; i++) {
      perform.verse1();
    }
    perform.verse2();
    perform.chorus();

    pause(2000);

  }
}
