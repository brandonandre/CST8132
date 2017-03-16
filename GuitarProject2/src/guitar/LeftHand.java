package guitar;

public class LeftHand implements GuitarPlayerLeftHand {
  Guitar guitar;

  public LeftHand(Guitar guitar) {
    this.guitar = guitar;
  }

  public void open() {
    for (int i = 1; i <= 6; i++) {
      guitar.fret(i, 0);
    }
  }

  public void hammerOn(int wireNum, int fretNum) {
    guitar.hammerOn(wireNum, fretNum);
  }

  public void c() {
    open();
    guitar.fret(2, 1);
    guitar.fret(4, 2);
    guitar.fret(5, 3);
  }

  public void cmaj7() {
    open();
    guitar.fret(4, 2);
    guitar.fret(5, 3);
  }

  public void d() {
    open();
    guitar.fret(1, 3);
    guitar.fret(2, 2);
    guitar.fret(3, 3);
  }

  public void dm7() {
    open();
    guitar.fret(1, 1);
    guitar.fret(2, 1);
    guitar.fret(3, 2);
  }

  public void dm7c() {
    open();
    guitar.fret(1, 1);
    guitar.fret(2, 1);
    guitar.fret(3, 2);
    guitar.fret(5, 3);
  }

  public void e7() {
    open();
    guitar.fret(3, 1);
    guitar.fret(5, 2);
  }

  public void e() {
    open();
    guitar.fret(3, 1);
    guitar.fret(4, 2);
    guitar.fret(5, 2);
  }

  public void f() {
    open();
    guitar.fret(2, 1);
    guitar.fret(3, 2);
    guitar.fret(4, 3);
    guitar.fret(6, 1);
  }

  public void g() {
    open();
    guitar.fret(1, 3);
    guitar.fret(2, 3);
    guitar.fret(5, 2);
    guitar.fret(6, 3);
  }

  public void gb() {
    open();
    guitar.fret(2, 3);
    guitar.fret(5, 2);
  }

  public void g7() {
    open();
    guitar.fret(1, 1);
    guitar.fret(5, 2);
    guitar.fret(6, 3);
  }

  public void a() {
    open();
    guitar.fret(2, 2);
    guitar.fret(3, 2);
    guitar.fret(4, 2);
  }

  public void am() {
    open();
    guitar.fret(2, 1);
    guitar.fret(3, 2);
    guitar.fret(4, 2);
  }

  public void b() {
    open();
    guitar.fret(1, 2);
    guitar.fret(2, 4);
    guitar.fret(3, 4);
    guitar.fret(4, 4);
    guitar.fret(5, 2);
  }

  public void bm() {
    open();
    guitar.fret(1, 2);
    guitar.fret(2, 4);
    guitar.fret(3, 4);
    guitar.fret(4, 3);
    guitar.fret(5, 2);
  }
}
