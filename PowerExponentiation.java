/*
Problem Statement:
Implement fast power exponentiation to calculate x^n (x raised to the power n) in O(log n) time.

Approach:
- If exponent n is odd → ans *= x; n-- 
- If exponent n is even → x = x * x; n /= 2
- If n is negative → return 1 / ans at the end
- Uses loop-based exponentiation by squaring for efficiency.

Input:
Enter base (x): 2
Enter exponent (n): 10

Output:
Result: 1024.0

Time Complexity: O(log n)
Space Complexity: O(1)
*/
import java.util.Scanner;

public class PowerExponentiation {

    static double power(double x, int n) {
        long m = n;
        double ans = 1.0;

        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            } else {
                x = x * x;
                n = n / 2;
            }
        }

        if (m < 0) {
            ans = 1.0 / ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();
        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();

        System.out.println("Result: " + power(x, n));
        sc.close();
    }
}
