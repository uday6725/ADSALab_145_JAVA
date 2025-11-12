// Problem: Coin Change Problem
// Task: Given an array of coins[] and an integer sum, find the total number of ways 
//       to make the given sum using different combinations of coins (unlimited supply).
// Example: coins[] = {1, 2, 3}, sum = 4 → Output = 4
// Explanation: Possible ways → {1,1,1,1}, {1,1,2}, {2,2}, {1,3}

// Strategy Used: Dynamic Programming

/*
Logic:-
1) This problem is a classic **Dynamic Programming** problem.
2) Strategy → Use a bottom-up DP approach to count combinations (not permutations).
3) Define dp[i][j] = number of ways to make sum ‘j’ using first ‘i’ coins.
4) Recurrence relation:
      dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
      → dp[i-1][j] → exclude current coin
      → dp[i][j - coins[i-1]] → include current coin (since we can reuse it)
5) Base Conditions:
      - dp[0][j] = 0 (no coins → no way)
      - dp[i][0] = 1 (sum 0 can be made in one way — by choosing nothing)
6) Time Complexity: O(N * sum)
   Space Complexity: O(N * sum)
*/

import java.util.*;

public class CoinChangeProblem {

    static int countWaysToMakeSum(int[] coins, int sum) {
        int N = coins.length;
        int[][] dp = new int[N + 1][sum + 1];

        // Base case: sum = 0 → 1 way (choose nothing)
        for (int i = 0; i <= N; i++)
            dp[i][0] = 1;

        // Fill dp table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[N][sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;

        System.out.println("Number of ways to make sum " + sum + " : " + countWaysToMakeSum(coins, sum));
    }
}
