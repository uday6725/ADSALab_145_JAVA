/*
--------------------------------------------
Problem Statement:
---------------------------------------------
Given a sorted binary array (consisting of only 0s and 1s),
count the number of zeros using an efficient approach (binary search).
The array is sorted in non-increasing order (1s first, then 0s).

--------------------------------------------
Input Format:
---------------------------------------------
- First line: An integer n (size of the array)
- Next line: n space-separated binary values (only 0s and 1s) in sorted (non-increasing) order

---------------------------------------------
Output Format:
---------------------------------------------
- Print the number of zeros in the array

---------------------------------------------
Example:
---------------------------------------------
Input:
7
1 1 1 0 0 0 0

Output:
Number of zeros: 4

---------------------------------------------
Time Complexity: O(log n) due to binary search
Space Complexity: O(1)
---------------------------------------------
*/

import java.util.Scanner;

public class CountZeros {

    public static void countZero(int[] arr, int n) {
        int low = 0, high = n - 1;
        int firstZero = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == 0) {
                if (mid == 0 || arr[mid - 1] == 1) {
                    firstZero = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        if (firstZero != -1) {
            System.out.println("Number of zeros: " + (n - firstZero));
        } else {
            System.out.println("No zeros found or invalid input");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (only 0s and 1s in sorted order):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        countZero(arr, n);
    }
}
