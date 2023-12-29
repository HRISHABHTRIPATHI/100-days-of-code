//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class 2Sum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        // Arrays.sort(arr);
        // int i=0, j=n-1, cnt=0;
        // while(i<j){
        // int sum = arr[i] + arr[j];
        // if(sum == k)
        // cnt++;
        // else if(sum<k)
        // i++;
        // else
        // j--;
        // }
        // return cnt;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(k - arr[i])) {
                count += hm.get(k - arr[i]);
            }
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        return count;
    }
}