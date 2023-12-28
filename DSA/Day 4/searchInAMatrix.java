//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}
// } Driver Code Ends


class Sol
{
    // static boolean binarySearch(int mat[], int X, int N, int M){
    //     int low = 0, high = N-1;
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if(X==mat[mid])
    //             return true;
    //         else if(X<mat[mid]){
    //             high = mid-1;
    //         }
    //         else if(X>mat[mid]){
    //             low = mid+1;
    //         }
    //     }
    //     return false;
    // }
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        // for(int i=0; i<N; i++){
        //     if(X>=mat[i][0] && X<=mat[i][M-1]){
        //         if(binarySearch(mat[i], X, N, M))
        //             return 1;
        //     }
        // }
        // return 0;
        
        // int low=0, high=N*M - 1;
        // while(low<=high){
        //     int mid=(low+high)/2;
        //     int row = mid/M;
        //     int col = mid%M;
        //     if(X==mat[row][col])
        //         return 1;
        //     else if(X<mat[row][col])
        //         low = mid+1;
        //     else if(X>mat[row][col])
        //         high = mid-1;
        // }
        // return 0;
        
        
        int ans=0;
        for(int i=0;i<N;i++)
        {
            if(X<mat[i][0] && X>mat[i][M-1])
            continue;
            for(int j=0;j<M;j++)
            {
               if(X==mat[i][j])
               ans=1;
            }
        }
        return ans;
    }
}
