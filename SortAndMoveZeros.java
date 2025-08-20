/*
-----------------------------------------------------
Problem Statement:
-----------------------------------------------------
Given an integer array containing some zero elements,
1. First sort the array using the Merge Sort algorithm.
2. Then move all zero elements to the end while maintaining the order of non-zero elements.

------------------------------------------------------
Input Format:
------------------------------------------------------ 
- Hardcoded array inside main function (modifiable)
  Example: {1, 3, 2, 0, 4, 0, 1}

------------------------------------------------------
Output Format:
------------------------------------------------------
- A single line showing the sorted array with all 0s moved to the end

------------------------------------------------------
Example:
------------------------------------------------------
Input:
[1, 3, 2, 0, 4, 0, 1]

Output:
1 1 2 3 4 0 0

------------------------------------------------------
Explanation:
- After sorting: [0, 0, 1, 1, 2, 3, 4]
- Move all 0s to the end while keeping non-zero order: [1, 1, 2, 3, 4, 0, 0]

------------------------------------------------------
Time Complexity:
- Merge Sort: O(n log n)
- Move Zeros to End: O(n)

Space Complexity:
- O(n) (for temp array in merge)
------------------------------------------------------
*/

public class SortAndMoveZeros {

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[100];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];

        for (int p = 0; p < k; p++)
            arr[left + p] = temp[p];
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void moveZerosToEnd(int[] arr, int n) {
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                arr[index++] = arr[i];
        }

        while (index < n)
            arr[index++] = 0;

        // Print final output
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 0, 4, 0, 1};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);
        moveZerosToEnd(arr, n);
    }
}
