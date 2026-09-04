package org.Preparation.module2;

import com.nit.service.ArithmeticOperations;

/**
 * Hello world!
 *
 */
public class StudentOperation 
{
    public static void main( String[] args )
    {
    	System.out.println("*******From Module2******");
        ArithmeticOperations ap1 = new ArithmeticOperations();
        System.out.println("Student Sum : "+ap1.sum(150, 150));
        
    }
}
