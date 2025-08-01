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
public class TankTest {
    
    public TankTest() {
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
     * Test of refuel method, of class Tank.
     */
    @Test
    public void testRefuel() {
        System.out.println("refuel");
        Tank instance = new Tank(100.00);
        instance.useFuel(2);
        instance.refuel();
        assertEquals(100.00, instance.checkFuel(), 0.00);
    }

    /**
     * Test of isLow method, of class Tank.
     */
    @Test
    public void testIsLow() {
        System.out.println("isLow");
        Tank instance = new Tank(100.00);
        boolean expResult = false;
        boolean result = instance.isLow();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkFuel method, of class Tank.
     */
    @Test
    public void testCheckFuel() {
        System.out.println("checkFuel");
        Tank instance = new Tank(100.00);
        double expResult = 100.00;
        double result = instance.checkFuel();
        assertEquals(expResult, result, 0.00);
    }

    /**
     * Test of useFuel method, of class Tank.
     */
    @Test
    public void testUseFuel() {
        System.out.println("useFuel");
        Tank instance = new Tank(100.00);
        instance.useFuel(2);
        assertEquals(98.00, instance.checkFuel(), 0.00);
    }
    
}
