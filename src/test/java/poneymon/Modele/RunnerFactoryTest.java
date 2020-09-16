/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author osboxes
 */
public class RunnerFactoryTest {
    
    public RunnerFactoryTest() {
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
     * Test of createRunner method, of class RunnerFactory.
     */
    @Test
    public void testCreateRunner() {
        System.out.println("createRunner");
        String type = "";
        Field f = null;
        String[] args = null;
        RunnerFactory instance = new RunnerFactory();
        Runner expResult = null;
        Runner result = instance.createRunner(type, f, args);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
