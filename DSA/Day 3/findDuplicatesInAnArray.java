//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class findDuplicatesInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        // ArrayList<Integer> ans = new ArrayList<>();
        // Arrays.sort(arr);
        // for(int i=0; i<n-1; i++){
        //     if(arr[i] == arr[i+1]){
        //         ans.add(arr[i]);
        //     }
        // }
        // if(ans.isEmpty()){
        //     ans.add(-1);
        // }
        // return ans;
        
        // Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // ArrayList<Integer> ans = new ArrayList<>();
        
        ArrayList<Integer> arrlist=new ArrayList<>();
        Arrays.sort(arr);
        int count=0;
        int value=arr[0];
        for(int i=0;i<n;i++){
            
            if(value!=arr[i] && count>1){
                arrlist.add(value);
                value=arr[i];
                count=0;
            }else if(value!=arr[i]){
                value=arr[i];
                count=0;
            }
            count++;
            
        }
        if(count>1){
            arrlist.add(arr[n-1]);
        }
        if(arrlist.isEmpty()){
            return new ArrayList<>(Arrays.asList(-1));
        }
        
        return arrlist;
    
    }
}

