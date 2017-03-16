import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BicycleTest {

  Bicycle testBike = new Bicycle();
  double initalSpeed;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    initalSpeed = testBike.getSpeed();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testPushPedal() {
    //The speed should change with a pedal press.
    testBike.pushPedal();
    assertTrue(testBike.getSpeed() == 4 + initalSpeed);
  }
  
  @Test
  public void testMakeNoise() {
    testBike.speed = 0;
    assertEquals(testBike.noise(), "sigh");
  }
  
  @Test
  public void maximumSpeed() {
    //Push the pedal 20 times, it should never go over 40. 
    for (int i=0; i < 20; i++){ 
      testBike.pushPedal();
      assertTrue(testBike.speed <= 40);
    }
  }
  
  @Test
  public void testMakeNoiseWithSpeed(){

    testBike.pushPedal();
    assertEquals(testBike.noise(), "grunt");
    
  }

}
