//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M, N));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        // code here
        // a[m][n] = 0 means m doesnot knows n so n cannot be celebrity but m could be
        // the potential celebrity

        // a[m][n] = 1 means m knows , so m cannot be celebrity but n can be the
        // potential celebrity

        // use stack, push all row no. to stack, then pop two elements from stack and
        // find potential celebrity using
        // above two conditions and push it to stack.

        // if stack finally has one element then check the two conditions for it
        // if no element in stack then no celebrity

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int val1 = st.pop();
            int val2 = st.pop();

            if (M[val1][val2] == 1)
                st.push(val2);
            else if (M[val1][val2] == 0)
                st.push(val1);
        }

        int potential;

        if (st.size() == 0) {
            return -1;
        }

        else {
            potential = st.peek();
            // check potential does not know anyone
            for (int i = 0; i < n; i++) {
                if (M[potential][i] == 1) {
                    return -1;
                }
            }

            // System.out.println(l);

            // check all knows potential except potential self
            for (int i = 0; i < n; i++) {
                if (i == potential) {
                    continue;
                }

                if (M[i][potential] == 0) {
                    return -1;
                }
            }
        }

        return potential;

    }
}
