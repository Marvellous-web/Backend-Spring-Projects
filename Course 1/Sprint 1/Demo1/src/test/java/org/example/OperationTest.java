package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationTest {
    Operation operation;
    @BeforeEach
    public void setup(){
        operation=new Operation();
    }
    @AfterEach
    public void clean(){
        operation=null;
    }
    @Test
    public void testAdd(){
        assertEquals(12,operation.add(5,7));
    }
    @Test
    public void testGetLeap(){
    assertEquals(Arrays.asList(1992,1996,2000),operation.getLeapYear(1990,2000));
    }
    @Test
    public void testDivFailure()
    {
        assertThrows(ArithmeticException.class,()->operation.div(12,0));
    }
    @Test
    public void testDivSuccess(){
        assertEquals(3,operation.div(12,4));
    }
    @Test
    public void testResult(){
        assertEquals("Pass",operation.getResult(51,98,64,63));
        assertEquals("Fail",operation.getResult(49,21,89,64));
    }
}
