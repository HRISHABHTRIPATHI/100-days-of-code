//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int ind = -1;
        for(int i=N-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
        }
        if(ind == -1){
            reverse(arr, 0, N-1);
        }
        int l=0;
        for(int i=N-1; i>ind; i--){
            if(arr[i] > arr[ind]){
                //swap arr[i] and arr[ind]
                l=i;
                
                break;
            }
        }
        swap(arr,l,ind);
        reverse(arr, ind+1, N-1);
        for(int i=0; i<N; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
    static void swap(int arr[], int k,int l){
        int temp =arr[k];
        arr[k] = arr[l];
        arr[l] = temp;
    }
    
    static void reverse(int arr[], int low,int high){
        
        while(low<high){
            swap(arr,low,high);
            low++;
            high--;
        }
    }
}
