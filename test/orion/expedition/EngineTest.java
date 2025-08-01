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
public class EngineTest {
    
    public EngineTest() {
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
     * Test of getEngineStatus method, of class Engine.
     */
    @Test
    public void testGetEngineStatus() {
        System.out.println("getEngineStatus");
        Engine instance = new Engine();
        boolean expResult = false;
        boolean result = instance.getEngineStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of startEngine method, of class Engine.
     */
    @Test
    public void testStartEngine() {
        System.out.println("startEngine");
        Engine instance = new Engine();
        instance.startEngine();
        boolean exp = true;
        boolean result = instance.getEngineStatus();
        assertEquals(exp,result);
    }

    /**
     * Test of stopEngine method, of class Engine.
     */
    @Test
    public void testStopEngine() {
        System.out.println("stopEngine");
        Engine instance = new Engine();
        instance.stopEngine();
        boolean result = instance.getEngineStatus();
        boolean exp = false;
        assertEquals(exp,result);
    }
    
}
