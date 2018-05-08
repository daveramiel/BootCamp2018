package com.topic1;

import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.assertEquals;


public class JUnitTesting {

    private JUnitTestingClass h;


    @Before
    public void setUp() throws Exception
    {
        h = new JUnitTestingClass();
    }

    @Test
    public void testHeyEmpty()
    {
        Result result = JUnitCore.runClasses(JUnitTestingClass.class);
        assertEquals(h.getMessage(""),"Hello person without a name!");
        System.out.println("Successful: " + result.wasSuccessful() +
                " ran " + result.getRunCount() + " tests");
    }

    @Test
    public void testHeyName()
    {
        Result result = JUnitCore.runClasses(JUnitTestingClass.class);
        assertEquals(h.getMessage("David"),"Hey David! sup?!");
        System.out.println("Successful: " + result.wasSuccessful() +
                " ran " + result.getRunCount() + " tests");
    }
}
