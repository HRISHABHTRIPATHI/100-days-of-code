//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(a, n, m));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int maxi(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static int sum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static int countStu(int[] A, int pages) {
        int stu = 1;
        int pageStu = 0;
        for (int i = 0; i < A.length; i++) {
            if (pageStu + A[i] <= pages) {
                pageStu += A[i];
            } else {
                stu++;
                pageStu = A[i];
            }
        }
        return stu;
    }

    // Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M) {
        // Your code here
        if (M > N) {
            return -1;
        }
        int low = maxi(A);
        int high = sum(A);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int noOfStu = countStu(A, mid);
            if (noOfStu > M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
};