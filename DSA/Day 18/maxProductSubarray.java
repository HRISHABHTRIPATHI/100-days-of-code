
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class maxProductSubarray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here

        // int pre = 1, suff = 1;
        // long ans = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // if (pre == 0) pre = 1;
        // if (suff == 0) suff = 1;
        // pre *= arr[i];
        // suff *= arr[n - i - 1];
        // ans = Math.max(ans, Math.max(pre, suff));
        // }
        // return ans;

        long prod1 = arr[0];
        long prod2 = arr[0];
        long res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            long temp = Math.max((long) arr[i], Math.max(prod1 * (long) arr[i], prod2 * (long) arr[i]));
            prod2 = Math.min((long) arr[i], Math.min(prod1 * (long) arr[i], prod2 * (long) arr[i]));
            prod1 = temp;
            res = Math.max(res, prod1);
        }
        return res;
    }
}