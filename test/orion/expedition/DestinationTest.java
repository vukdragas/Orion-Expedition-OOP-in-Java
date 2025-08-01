/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package orion.expedition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wolfd
 */
public class DestinationTest {
    
    public DestinationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateProgress method, of class Destination.
     */
    @Test
    public void testUpdateProgress() {
        System.out.println("updateProgress");
        Destination instance = new Destination("Mars", 100, 75, 2.0);
        int expected = 5;
        instance.updateProgress(instance.getDistanceFromEarth());
        int result = instance.getTravelProgress();
        assertEquals(expected ,result);
    }

    /**
     * Test of isReached method, of class Destination.
     */
    @Test
    public void testIsReached() {
        System.out.println("isReached");
        Destination instance = new Destination("Earth", 0, 75, 3.0);
        boolean expResult = true;
        boolean result = instance.isReached();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObserveDestination(){
        Destination instance = new Destination("Earth", 0, 75, 3.0);
        instance.observeDestination(3);
        assertEquals(3.0, instance.getObservationCompletion(), 0.0);
    
    }
    
}
