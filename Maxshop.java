/*
 Problem: Activity Selection Problem with K Persons
 Statement:
   Given two arrays S[] and E[] of size N denoting starting and closing time of the shops 
   and an integer value K denoting the number of people, the task is to find out the maximum 
   number of shops they can visit in total if they visit each shop optimally based on the following conditions:
   - A shop can be visited by only one person.
   - A person cannot visit another shop if its timing collides with it.

 Input:
   enter the number of shops
   3
   enter the starting time of the shops
   1 3 0
   enter the ending time of the shops
   2 4 6
   enter the number of persons
   2

 Output:
   maximum shops visited 3
*/

import java.util.Scanner;

public class Maxshop {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number of shops");
        int n = sc.nextInt();

        int S[] = new int[n];
        int E[] = new int[n];
        System.out.println("enter the starting time of the shops");
        for (int i = 0; i < n; i++) {
            S[i] = sc.nextInt();
        }

        System.out.println("enter the ending time of the shops");
        for (int i = 0; i < n; i++) {
            E[i] = sc.nextInt();
        }

        System.out.println("enter the number of persons");
        int k = sc.nextInt();

        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (E[j] > E[j + 1]) {
                    int temp = E[j];
                    E[j] = E[j + 1];
                    E[j + 1] = temp;

                    temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;
                }
            }
        }

        int last_end[] = new int[k];
        for (int i = 0; i < k; i++) {
            last_end[i] = Integer.MIN_VALUE;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < k; p++) {
                if (S[i] >= last_end[p]) {
                    last_end[p] = E[i];
                    count++;
                    break;
                }
            }
        }

        System.out.println("maximum shops visited " + count);
        sc.close();
    }
}
