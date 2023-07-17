package org.example;

import org.example.Config.MovieConfigBean;
import org.example.Model.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(MovieConfigBean.class);
        Movie m1=(Movie)context.getBean("Movie1");
        System.out.println(m1);
        Movie m2=context.getBean("Movie2", Movie.class);
        System.out.println(m2);

        //Equals MEthod
        // Java Program to Check If Two Arrays Are Equal
// Using equals() method of Arrays class

// Importing required classes


                // Declaring integer arrays
                int arr1[] = { 1, 2, 3 };
                int arr2[] = { 1, 2, 3 };

                // Checking if above two arrays are equal
                // using equals() method

                if (Arrays.equals(arr1, arr2))


                    // Print statement if arrays are equal
                    System.out.println("Same");
                else

                    // Print statement if arrays are equal
                    System.out.println("Not same");
            }
        }

