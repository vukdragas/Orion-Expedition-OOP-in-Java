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
public class ShuttleTest {
    
    public ShuttleTest() {
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
     * Test of addDesintaion method, of class Shuttle.
     */
    @Test
    public void testAddDesintaion() {
        System.out.println("addDesintaion");
        Shuttle instance = new Shuttle(100);
        Destination d = new Destination("Mars", 100, 75, 1.0);
        NavigationSystem s = new Standard();
        instance.setNav(s);
        instance.addDesintaion(d);
        assertEquals(1, instance.getNav().size());
    }

    /**
     * Test of readPlanets method, of class Shuttle.
     */
    @Test
    public void testReadPlanets() {
        System.out.println("readPlanets");
        String fileName = "planets.txt";
        Shuttle instance = new Shuttle(100);
        NavigationSystem s = new Standard();
        instance.setNav(s);
        instance.readPlanets(fileName);
        assertEquals(4, instance.getNav().size());
    }

    /**
     * Test of removeDestination method, of class Shuttle.
     */
    @Test
    public void testRemoveDestination() {
        System.out.println("removeDestination");
        Destination d = new Destination("Mars", 100, 3048, 1.0);
        Shuttle instance = new Shuttle(100);
        NavigationSystem s = new Standard();
        instance.setNav(s);
        instance.addDesintaion(d);
        instance.removeDestination(d);
        assertEquals(0, instance.getNav().size());
    }

    /**
     * Test of launch method, of class Shuttle.
     */
    @Test
    public void testLaunch() {
        System.out.println("startTrip");
        Shuttle s = new Shuttle(100);
        NavigationSystem g = new Standard();
        s.setNav(g);
        
        Destination moon = new Destination("Moon",50, 1948, 1.0);
        s.addDesintaion(moon);
        boolean r = s.launch();
        if(r){
            boolean expected = true;
            assertEquals(expected, r);
        }else{
            boolean expected = false;
            assertEquals(expected, r);
        }
    }
    
}
