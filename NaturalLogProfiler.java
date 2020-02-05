/**
 * Manipulates the fast and naive log functions created in the natural logger class.
 * @author Rayshaad Thomas
 * @since January 28, 2020
 * @see NaturalLogger
 */
package NaturalLogProfiler;
import static NaturalLogProfiler.NaturalLogger.*;
import java.util.Random;
import java.util.Scanner;
public class NaturalLogProfiler {
    public static void main(String[] args) {
        //prompts the user to enter a number whose natural logarithm is to be approximated.
        System.out.print("Enter a number to approximate its natural log -> ");
        Scanner in = new Scanner(System.in);
        double value1 = in.nextDouble();
        /* It computes an approximation for the natural log of the number using versions 
         * of the fast and naive ln method with an arity of one and displays approximate 
         * natural logs.
         */
        System.out.println("\nNaive Algorithm: ln(" + value1 + ") ~ " + naiveLn(value1));
        System.out.println("Fast Algorithm: ln(" + value1 + ") ~ " + fastLn(value1) + "\n");
        //It randomly generates a three-digit positive integer.
        Random r = new Random();
        double rValue1 = Math.random() * 999 + 100; 
        /* Similarly, it computes an approximation for the natural log of the randomly 
         * generated three-digit number using both the fast and naive methods with an 
         * arity of one and displays the approximate natural logs.
         */
        System.out.println("For a random 3-digit positive integer:\n");
        System.out.println("Naive Algorithm: ln(" + rValue1 + ") ~ " + naiveLn(rValue1));
        System.out.println("Fast Algorithm: ln(" + rValue1 + ") ~ " + fastLn(rValue1) + "\n");
        /* It prompts the user to enter a real number whose approximate natural log will 
         * be calculated using varying numbers of terms of the series in Equation eq1 
         * with your implementations of the fast and naive algorithms. It displays the 
         * runtimes for generating various approximations.
         */
        System.out.print("Enter x to generate approximations for ln(x) -> ");
        double value2 = in.nextDouble();
        System.out.println("\nx = " + value2);
        /* For number of terms n ∈ {1000i,i ∈ Z|1 ≤ i ≤ 10}, the program will compute, 
         * using the naive and fast algorithms, approximate natural logs of the number 
         * entered by the user and measure and display the execution times in nanoseconds 
         * for these algorithms as shown in the table in Listing 1.
         */
        System.out.println("---------------------------------------------------------\n#Terms\tFast ln(" + value2 + ") (ns)\tNaive ln(" + value2 + ") (ns)\n---------------------------------------------------------");
        for (int i = 1000; i<= 10000; i += 1000){
            long startTime = System.nanoTime();
            fastLn(value2, i);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.print(i + "\t\t" + totalTime + "\t\t");
            startTime = System.nanoTime();
            naiveLn(value2, i);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println(totalTime);
        }
    }  
}