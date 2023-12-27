//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String[] s = br.readLine().trim().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                int[][] matrix = new int[n][m];
                for(int i = 0; i < n; i++){
                    String[] S = br.readLine().trim().split(" ");
                    for(int j = 0; j < m; j++)
                        matrix[i][j] = Integer.parseInt(S[j]);
                }
                Solution ob = new Solution();
                ob.MakeZeros(matrix);
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    
    class Solution {
        
         public void  MakeZeros(int[][] matrix)
        {
            // code here
            int m=matrix.length,n=matrix[0].length;
            int [][] temp = new int[m][];
            for(int i = 0; i < m; i++)
                temp[i] = matrix[i].clone();
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(temp[i][j]==0){
                        FixSum(i,j,m,n,matrix,temp);
                    }
                }
            }
        }
        public void FixSum(int i,int j,int m,int n,int[][] matrix,int[][] temp){
            
        if(i>0){ //for Up element
            matrix[i][j]+=temp[i-1][j];
            matrix[i-1][j]=0;
        }
        if(j>0){//for left element
            matrix[i][j]+=temp[i][j-1];
            matrix[i][j-1]=0;
        }
        if(j<n-1){
            matrix[i][j]+=temp[i][j+1];
            matrix[i][j+1]=0;
        }
        if(i<m-1){
            matrix[i][j]+=temp[i+1][j];
            matrix[i+1][j]=0;
        }
        }
    }