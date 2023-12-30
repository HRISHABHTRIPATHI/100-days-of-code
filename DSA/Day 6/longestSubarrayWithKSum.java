//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int a[], int N, int K) {
        // Complete the function
        for (int i = 1; i < N; i++)
            a[i] += a[i - 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int val = a[i] - K;
            if (map.containsKey(val)) {
                res = i - map.get(val);
                max = Math.max(max, res);
            }
            if (!map.containsKey(a[i]))
                map.put(a[i], i);
        }
        return max;
    }

}
