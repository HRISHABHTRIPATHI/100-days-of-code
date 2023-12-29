//{ Driver Code Starts
// Initial Template for C++

#include<bits/stdc++.h>#include<iostream>using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    void merge(vector<int>&arr,int low, int mid, int high){
        // long long size=high-low+1;
        vector<int>temp; // temporary array
        int left=low;//starting ind of left half of array
        int right=mid+1; //starting ind of  right of array
        // int cnt=0;
        //storing ele in sorted order in temp array
        
        while(left<=mid && right<=high){
            //left is smaller
            if(arr[left]<=arr[right]){
                temp.push_back(arr[left]);
                left++;
            }
            //right is smaller
            else{
                temp.push_back(arr[right]);
                // cnt+=(mid-left+1);
                right++;
            }    
        }
        
        //if ele are left in the left array
        while(left<=mid){
            temp.push_back(arr[left]);
            left++;
            
        }
        
        //if ele are left in the right array
        while(right<=high){
            temp.push_back(arr[right]);
            right++;
            
        }
        
        //transfering all ele from  temp to arr
        for(int i=low; i<=high;i++){
            arr[i]=temp[i-low];
        }
        
        
    }

    int countPairs(vector<int> &arr, int low, int mid, int high){
        int cnt=0; 
        int right=mid+1;

        for(int i=low; i<=mid;i++){
            while(right<=high && (long long)arr[i]> (long long)2*arr[right]){
                right++;
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }

    int mergeSort(vector<int>&arr, int low, int high){
        int cnt=0;
        if(low>=high) return cnt;
        
        int mid=low + (high-low)/2;
        cnt+=mergeSort(arr, low, mid);
        cnt+=mergeSort(arr, mid+1, high);
        cnt+=countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }

    int countRevPairs(int n, vector<int> arr) {
        // Code here
        mergeSort(arr,0,n-1);
    }
};

    // { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr;

        for (int i = 0; i < n; ++i) {
            int x;
            cin >> x;
            arr.push_back(x);
        }

        Solution obj;
        cout << obj.countRevPairs(n, arr) << endl;
    }
    return 0;
}
// } Driver Code Ends