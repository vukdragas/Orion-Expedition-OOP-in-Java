/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package orion.expedition;

import java.util.List;
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
public class StandardTest {
    
    public StandardTest() {
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
     * Test of getNextTravelDestination method, of class Standard.
     */
    @Test
    public void testGetNextTravelDestination() {
        System.out.println("getNextTravelDestination");
        Shuttle s = new Shuttle(100);
        NavigationSystem g = new Standard();
        s.setNav(g);
        Destination moon = new Destination("Moon",10, 5, 1.0);
        s.addDesintaion(moon);
        s.readPlanets("planets.txt");
        
        Destination closest = g.goToNextDestination();
        
        assertEquals(moon, closest);
    }

    
}
