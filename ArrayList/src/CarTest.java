import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

  Car testCar = new Car();
  double initalSpeed;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    initalSpeed = testCar.getSpeed();
  }

  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testPushPedal() {
    //Push the pedal, The speed should increase by 10.
    testCar.pushPedal();
    assertTrue(testCar.getSpeed() == 10.0 + initalSpeed); 
  }
  
  @Test
  public void testMakeNoise() {
    //If the car is at zero, it should make a purr noise.
    testCar.speed = 0;
    assertEquals(testCar.noise(), "purr");
  }
  
  @Test
  public void testMakeNoiseWithSpeed(){
    //Push the pedal, then check the speed.
    testCar.pushPedal();
    assertEquals(testCar.noise(), "vroom");
    
  }
  
}
