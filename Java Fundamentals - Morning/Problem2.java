import java.io.*;
import java.util.*;

public class Problem2 {

    public static void main(String args[]) {
        division(2,2);
        System.out.println("-----------------------------");
        division(2,-2);
        System.out.println("-----------------------------");
        division(2,0);
    }

    public static void division(int a, int b) throws ArithmeticException {
        try {
            if(a+b == 0){
                throw new ArithmeticException("Exception using throw");
            }
            else {
                int d = a / b;
                System.out.println("Division = "+ d);
            }
        }

        catch(Exception e) {
            System.out.println(e);
            System.out.println("Exception Occured");
        }
    }
}