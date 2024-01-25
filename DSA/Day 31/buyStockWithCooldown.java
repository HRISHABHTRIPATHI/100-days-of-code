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
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long price[], int N){
        //Code here
        long dp[][] = new long[N+2][2];
        
        for(int i = N-1 ; i >= 0 ; i--){
                
             dp[i][1] = Math.max(-price[i] + dp[i+1][0] , dp[i+1][1]);
        
             dp[i][0] = Math.max( price[i] + dp[i+2][1] , dp[i+1][0]);
    
        }
        return dp[0][1];
    }
}
