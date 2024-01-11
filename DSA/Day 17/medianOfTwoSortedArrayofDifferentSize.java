//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int m = sc.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i++)
                b[i] = sc.nextInt();

            double res = new GFG().medianOfArrays(n, m, a, b);

            if (res == (int) res)
                System.out.println((int) res);
            else
                System.out.println(res);
        }

    }
}
// } Driver Code Ends

// User function Template for Java

class GFG {
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        // Your Code Here
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            list.add(b[i]);
        }

        Collections.sort(list);
        int x = n + m;

        return findMiddle(list, x);

    }

    public static double findMiddle(ArrayList<Integer> list, int x) {
        int size = x;

        if (size == 0) {
            throw new IllegalArgumentException("ArrayList is empty");
        }

        int middleIndex = size / 2;

        if (size % 2 == 1) {
            // Odd-sized ArrayList
            return list.get(middleIndex);
        } else {
            // Even-sized ArrayList
            int middleElement1 = list.get(middleIndex - 1);
            int middleElement2 = list.get(middleIndex);
            return (middleElement1 + middleElement2) / 2.0;
        }
    }
}