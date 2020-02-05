/*
 * Implementation for the fast and naive natural log series approximation 
 * algorithms that use the series:
 * 2*Sigma[i=1:n, 1/(2i-1)*[(x-1)/(x+1)]^(2i-1)]
 * @author Rayshaad Thomas
 * @since January 28, 2020
 * @see NaturalLogProfiler
 */
package NaturalLogProfiler;
public class NaturalLogger{
    /**
     * Computes a power with an integer exponent
     * @param b the base of the power
     * @param n an integer representing the exponent of the power
     * @return the power equivalent to the specified base to the specified
     * exponent
     * @throws IllegalArgumentException when b == 0 and n <= 0
     */
    private static double iPow(double b, int n) throws IllegalArgumentException{
        double power = b;
        if (b == 0 && n <= 0) throw new IllegalArgumentException ("Undefined.");
        else if (b == 0 && n > 0) power = 0;
        else if (n == 0) power = 1;
        else if (b == 1) power = 1;
        else if ((b > 0 || b < 0) && n == 1) power = b;
        else if ((b > 0 || b < 0) && n == -1) power = 1/b;
        else if (b == -1 && n % 2 == 0) power = 1;
        else if (b == -1 && n % 2 != 0) power = -1;
        else if ((b > 0 || b < 0) && n > 0){
            for (int i = 1; i != n; i++){
                b = power * b;
            }
            power = b;
        }
        else if ((b > 0 || b < 0) && n < 0){
            for (int i = 1; i != n; i++){
                b = power * b;
            }
            power = (1/b);
        }
        return power;
    }
    /**
     * Gives an approximation of the natural log function by naively computing
     * the series 2*Sigma[i=1:50000, 1/(2i-1)*[(x-i)/(x+1)]^(2i-1)]
     * @param x a number whose natural log is to be approximated
     * @return the series approximation of ln(x) using the first 50000 terms
     * @throws IllegalArgumentException when x <= 0
     */
    public static double naiveLn(double x) throws IllegalArgumentException{
        double halfLn = 0;
        for (int i = 1; i != 50000; i++){
            halfLn += (iPow( (x - 1) / (x + 1), 2*i - 1) / ( 2*i - 1) );
        }
        return 2 * halfLn;		
    }
    /**
     * Gives an approximation of the natural log function by naively computing
     * the series 2*Sigma[i=1:n,1/(2i-1) *[(x-i)/(x+1)]^(2i-1)]
     * @param x a number whose natural log is to be approximated
     * @param n the number of terms in the series
     * @return the series approximation value for ln(x) using the first n terms
     * @throws IllegalArgumentException when x <= 0 or n <= 0
     * <pre>
     * Note: The series should be generated without the use of a nested loop
     * or any standard math library functions; To determine powers use the 
     * user-defined iPow function in this class. Each term of the series is 
     * independently determined using the function that serves as the summand 
     * of the series.
     * </pre>
     */
    public static double naiveLn(double x, int n) throws IllegalArgumentException{
        double halfLn = 0;
        for (int i = 1; i <= n; i++){
            halfLn += (iPow( (x - 1) / (x + 1), 2*i - 1) / ( 2*i - 1) );
        }
        return 2 * halfLn;		
    }
    /**
     * Gives an approximation of the natural log function using the fast
     * approximation algorithm that computes the series 
     * 2*Sigma[i=1:50000, 1/(2i-1) *[(x-i)/(x+1)]^(2i-1)]
     * @param x a number whose natural log is to be approximated
     * @return the series approximation of ln(x) using the first 50000 terms
     * @throws IllegalArgumentException when x <= 0
     */    
    public static double fastLn(double x) throws IllegalArgumentException{
        double alpha = (x-1)/(x+1);
        double halfLn = 0;
        int odd;
        for (odd = 1; odd <= 50000; odd += 2){
            halfLn += alpha /odd;
            alpha *= ((x-1)/(x+1)) * ((x-1)/(x+1));
        }
        return 2 * halfLn;		
    }
    /**
     * Gives an approximation of the natural log function by using the fast algorithm
     * to compute the series 2*Sigma[i=1:n,(1/(2i-1) *[(x-i)/(x+1)]^(2i-1)]]
     * @param x a number whose natural log is to be approximated
     * @param n the number of terms in the series
     * @return the series approximation value for ln(x) using the first n terms
     * @throws IllegalArgumentException when x <= 0 or n <= 0
     * <pre>
     * Note: Except for the first term of the series, each term is generated from its
     * predecessor and without the use or any standard math library functions; 
     * Neither the standard math library functions or the user-defined iPow function
     * should be invoked in this function. This function should not use a nested loop
     * to compute the powers. Each successive power must be generated from the preceding
     * power.
     * </pre>
     */ 
    public static double fastLn(double x, int n) throws IllegalArgumentException{ 
        double halfLn = 0;
        int oddNum;
        double oddPower = a;
        for (oddNum = 1; oddNum <= n; oddNum += 2){
            halfLn += oddPower/oddNum;
            oddPower *= ((x-1)/(x+1)) * ((x-1)/(x+1));
        }
        return 2 * halfLn;
    }  
}