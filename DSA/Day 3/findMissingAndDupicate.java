//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class findMissingAndDuplicate {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int rep=0;
        int mis=0;
        int freq [] = new int[n+1];
        for(int i=0; i<n; i++){
            freq[arr[i]]++;
        }
        for(int i=1; i<=n; i++){
            if(freq[i]==2){
                rep=i;
            }
            if(freq[i]==0){
                mis=i;
            }
        }
        int [] ans = new int[2];
        ans[0] = rep;
        ans[1] = mis;
        return ans;
    }
}