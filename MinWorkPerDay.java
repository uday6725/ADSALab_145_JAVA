// Problem: Minimum Work to be Done per Day to Finish Given Tasks within D Days
// Task: Find the minimum amount of work per day required so that all tasks can be completed in at most D days.
// Example: task[] = {3, 2, 4, 7, 2, 5}, D = 4 → Output = 7

// Strategy Used: Greedy Algorithm

/*
Logic:-
1) Each day you can work on only one task at a time, and tasks must be finished in order.
2) To minimize the maximum work per day (and still finish in ≤ D days),
   we greedily assign tasks day by day:
   - Keep adding work for the current day until adding the next task would exceed our limit.
   - When exceeded, move to the next day.
3) The goal is to find the smallest possible daily workload that allows finishing all tasks within D days.
4) Approach:
   - Start with total work = 0 and days = 1.
   - Traverse through each task:
        → If current day’s work + this task > current limit → assign it to the next day.
        → Else add it to the current day’s work.
   - Finally, increase limit greedily until all tasks fit within D days.
5) Time Complexity: O(N)
   Space Complexity: O(1)
*/

import java.util.*;

public class MinWorkPerDay {

    static int minWorkPerDay(int[] task, int D) {
        int N = task.length;

        int totalWork = 0;
        int maxTask = 0;
        for (int t : task) {
            totalWork += t;
            maxTask = Math.max(maxTask, t);
        }

        int dailyLimit = maxTask; // Start with the largest single task

        // Greedily increase the limit until all tasks fit in D days
        while (true) {
            int days = 1, currentWork = 0;
            for (int t : task) {
                if (currentWork + t <= dailyLimit) {
                    currentWork += t;
                } else {
                    days++;
                    currentWork = t;
                }
            }
            if (days <= D) break;  // Found the minimum daily work
            dailyLimit++;
        }

        return dailyLimit;
    }

    public static void main(String[] args) {
        int[] task = {3, 2, 4, 7, 2, 5};
        int D = 4;

        System.out.println("Minimum work per day required: " + minWorkPerDay(task, D));
    }
}
