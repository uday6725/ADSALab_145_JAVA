/*
Problem Statement:
Given a number `n`, find the **smallest number** such that the **factorial** of that number contains at least `n` trailing zeroes.
Trailing zeroes are caused by the product of multiples of 5 and 2 in the factorial. This algorithm efficiently uses binary search to find the smallest such number.

Approach:
1. Count how many trailing zeroes a number's factorial has by dividing it repeatedly by 5.
2. Apply binary search in the range [0, 5 * n] to find the minimum number with at least n trailing zeroes in its factorial.

Input:
Enter number of trailing zeroes: 5

Output:
Smallest number whose factorial has at least 5 trailing zeroes is: 25
*/

import java.util.Scanner;

public class TrailingZeroes {

    static int countTrailingZeros(int x) {
        int count = 0;
        while (x >= 5) {
            x /= 5;
            count += x;
        }
        return count;
    }

    static int findSmallestNumber(int n) {
        int low = 0, high = 5 * n;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int zeros = countTrailingZeros(mid);

            if (zeros >= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of trailing zeroes: ");
        int n = sc.nextInt();
        System.out.println("Smallest number whose factorial has at least " + n + " trailing zeroes is: " + findSmallestNumber(n));
        sc.close();
    }
}
