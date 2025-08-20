/*
 Problem: Maximum Subarray (Divide & Conquer)
 Description: Find contiguous subarray with largest sum (Divide & Conquer version).
 Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 Output: 6 (subarray [4, -1, 2, 1]) 
*/ 

public class MaxSubarrayDivideConquer {

    
    private static int maxCrossingSum(int arr[], int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

       
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        
        return leftSum + rightSum;
    }

    
    private static int maxSubArraySum(int arr[], int left, int right) {
        
        if (left == right)
            return arr[left];

        int mid = (left + right) / 2;

       
        return Math.max(
            Math.max(maxSubArraySum(arr, left, mid), maxSubArraySum(arr, mid + 1, right)),
            maxCrossingSum(arr, left, mid, right)
        );
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;

        int maxSum = maxSubArraySum(arr, 0, n - 1);
        System.out.println("Maximum Subarray Sum is: " + maxSum);
    }
}
