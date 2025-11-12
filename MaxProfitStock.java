// Problem: Maximizing Profit by Trading Stocks
// Task: Given stock prices for N days, find the maximum profit achievable 
//       by buying and selling stocks optimally (you can buy and sell multiple times).
// Example: arr[] = {1, 5, 3, 8, 12} → Output = 13
// Explanation: Buy at 1, sell at 5 (profit=4), buy at 3, sell at 12 (profit=9) → total = 13

// Strategy Used: Greedy Algorithm

/*
Logic:-
1) The problem is based on the "Buy and Sell Stock II" concept.
2) Strategy → Greedy approach: Add up all the profit opportunities 
   whenever the price increases from one day to the next.
3) Steps:
   - Traverse the array from the 2nd day to the last.
   - If price on day i > price on day (i-1), 
       → it means buying at (i-1) and selling at (i) gives profit.
       → Add (arr[i] - arr[i-1]) to total profit.
   - Continue for all days.
4) Finally, the accumulated profit gives the maximum possible profit.
5) Time Complexity: O(N)
   Space Complexity: O(1)
*/

import java.util.*;

public class MaxProfitStock {

    // Function to calculate maximum profit
    static int maxProfit(int[] arr) {
        int profit = 0;
        int N = arr.length;

        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 12};
        System.out.println("Maximum Profit: " + maxProfit(arr));
    }
}
