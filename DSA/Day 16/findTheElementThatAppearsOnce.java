//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            System.out.println(new Sol().search(arr, n));
        }

    }
}
// } Driver Code Ends

// User function Template for Java

class Sol {
    public static int search(int arr[], int n) {
        // your code here
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if arr[mid] is the single element:
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // we are in the left:
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1])
                    || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                // eliminate the left half:
                low = mid + 1;
            }
            // we are in the right:
            else {
                // eliminate the right half:
                high = mid - 1;
            }
        }

        // dummy return statement:
        return -1;
    }
}