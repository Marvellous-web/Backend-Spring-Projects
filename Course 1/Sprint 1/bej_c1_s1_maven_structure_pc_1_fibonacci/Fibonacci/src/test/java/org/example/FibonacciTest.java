package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FibonacciTest {
    Fibonacci fibonacci;

    @BeforeEach
    public void setup(){
        fibonacci=new Fibonacci();
    }
    @AfterEach
    public void clean(){
        fibonacci=null;
    }

    @Test
    public void FibonaaciTest(){
        assertEquals(34,fibonacci.fib(9));
    }
    @Test
    public  void getSeries(){
        assertEquals(Arrays.asList(1,2,3,5,8,13,21,34),fibonacci.getSeries(9));
    }
}
