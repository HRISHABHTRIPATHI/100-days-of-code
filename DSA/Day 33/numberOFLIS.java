//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int N, int arr[]){
        // Code here
        int[] dp = new int[N];

        int[] count = new int[N];

        Arrays.fill(dp,1);

        Arrays.fill(count,1);

        int maxi = Integer.MIN_VALUE;

        for(int i = 0;i<N;i++){

            for(int j = 0;j<i;j++){

                if(arr[i] > arr[j] && dp[j] + 1 > dp[i]){

                    dp[i] = dp[j] + 1;

                    count[i] = count[j];

                }

                else if(arr[i] > arr[j] && dp[i] == dp[j] + 1){

                    count[i]+=count[j];

                }

            }

            maxi = Math.max(maxi,dp[i]);

        }

        int ans = 0;

        for(int i = 0;i<N;i++){

            if(dp[i] == maxi) ans+=count[i];

        }

        return ans;
    }
}