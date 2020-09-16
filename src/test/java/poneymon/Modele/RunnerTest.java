/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bobsloth
 */
public class RunnerTest {
    
    public RunnerTest() {
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
     * Test of completeInit method, of class Runner.
     */
    @Test
    public void testCompleteInit() {
        System.out.println("completeInit");
        Runner instance = null;
        instance.completeInit();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Runner.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Runner instance = null;
        instance.move();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newLap method, of class Runner.
     */
    @Test
    public void testNewLap() {
        System.out.println("newLap");
        Runner instance = null;
        instance.newLap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRunner method, of class Runner.
     */
    @Test
    public void testAddRunner() {
        System.out.println("addRunner");
        Runner r = null;
        int i = 0;
        Runner instance = null;
        instance.addRunner(r, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistance method, of class Runner.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        int i = 0;
        Runner instance = null;
        int expResult = 0;
        int result = instance.getDistance(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Runner.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Runner instance = null;
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbTours method, of class Runner.
     */
    @Test
    public void testGetNbTours() {
        System.out.println("getNbTours");
        Runner instance = null;
        int expResult = 0;
        int result = instance.getNbTours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Runner.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Runner instance = null;
        double expResult = 0.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeed method, of class Runner.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        Runner instance = null;
        double expResult = 0.0;
        double result = instance.getSpeed();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRunners method, of class Runner.
     */
    @Test
    public void testGetRunners() {
        System.out.println("getRunners");
        Runner instance = null;
        ArrayList<Runner> expResult = null;
        ArrayList<Runner> result = instance.getRunners();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeed method, of class Runner.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        double speed = 0.0;
        Runner instance = null;
        instance.setSpeed(speed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Runner.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        double x = 0.0;
        Runner instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRessourcePath method, of class Runner.
     */
    @Test
    public void testGetRessourcePath() {
        System.out.println("getRessourcePath");
        Runner instance = null;
        String expResult = "";
        String result = instance.getRessourcePath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRessourcePath method, of class Runner.
     */
    @Test
    public void testSetRessourcePath() {
        System.out.println("setRessourcePath");
        String ressourcePath = "";
        Runner instance = null;
        instance.setRessourcePath(ressourcePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getField method, of class Runner.
     */
    @Test
    public void testGetField() {
        System.out.println("getField");
        Runner instance = null;
        Field expResult = null;
        Field result = instance.getField();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Runner.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Runner instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Runner.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        double y = 0.0;
        Runner instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of jump method, of class Runner.
     */
    @Test
    public void testJump() {
        System.out.println("jump");
        Runner instance = null;
        instance.jump();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enableJump method, of class Runner.
     */
    @Test
    public void testEnableJump() {
        System.out.println("enableJump");
        Runner instance = null;
        instance.enableJump();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class RunnerImpl extends Runner {

        public RunnerImpl() {
            super(null, 0.0, 0.0, "", "");
        }
    }
    
}
