//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(inputLine[i]);
            long[] res = new Solution().nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        long result[] = new long[n];
        result[n - 1] = -1;
        long cmax = arr[n - 1], flag = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                result[i] = arr[i + 1];
            } else {
                if (arr[i] > cmax) {
                    result[i] = -1;
                    cmax = arr[i];

                } else {
                    int j = i + 1;
                    while (j < n && arr[j] <= arr[i]) {
                        j++;
                    }
                    if (j < n)
                        result[i] = arr[j];
                    else
                        result[i] = -1;

                }

            }
        }
        return result;
    }
}