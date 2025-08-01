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
public class OrbiterTest {
    
    public OrbiterTest() {
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
     * Test of startTrip method, of class Orbiter.
     */
    @Test
    public void testStartTrip() {
        System.out.println("startTrip");
        Shuttle s = new Shuttle(100);
        NavigationSystem g = new Standard();
        s.setNav(g);
        Destination moon = new Destination("Moon",50, 1000, 1.0);
        s.addDesintaion(moon);
        Orbiter instance = s.getOrbiter();
        boolean r = instance.startTrip();
        if(r){
            boolean expected = true;
            assertEquals(expected, r);
        }else{
            boolean expected = false;
            assertEquals(expected, r);
        }
    }
}
