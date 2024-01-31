//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array, n);

            for (int i = 0; i < n; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int[] help_classmate(int arr[], int n) {
        // Your code goes here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.empty()) {
                list.add(-1);
            } else if (st.size() > 0 && st.peek() < arr[i]) {
                list.add(st.peek());
            } else if (st.size() > 0 && st.peek() >= arr[i]) {
                while (!st.empty() && st.peek() >= arr[i]) {
                    st.pop();
                }
                if (st.empty()) {
                    list.add(-1);
                } else {
                    list.add(st.peek());
                }
            }
            st.push(arr[i]);
        }

        Collections.reverse(list); // Reverse the list.

        // Convert ArrayList to an array.
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
