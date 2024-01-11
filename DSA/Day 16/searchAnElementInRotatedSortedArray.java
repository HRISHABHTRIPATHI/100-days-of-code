//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.Search(array, target));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int Search(int array[], int k) {
        // code here
        int n = array.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == k)
                return mid;
            // left half
            if (array[low] <= array[mid]) {
                // element is present
                if (array[low] <= k && k <= array[mid])
                    high = mid - 1;
                // element is not present
                else
                    low = mid + 1;
            }
            // right half
            else {
                // element is prsent
                if (array[mid] <= k && k <= array[high])
                    low = mid + 1;
                // element is not present
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
