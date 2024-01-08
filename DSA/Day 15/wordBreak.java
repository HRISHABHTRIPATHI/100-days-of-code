//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>using namespace std;

// } Driver Code Ends
//User function template for C++

// A : given string to search
// B : vector of available strings

class wordBreak {
public:
//  help function to know whether we can break the string till ith index using words of B
    int help(int i , string &A, vector<string>&B ,vector<int>&dp){
        if(i<0) return 1 ; //all empty
        if(dp[i]!=-1) return dp[i]==1; //return stored value( breakable till ith index)
        for(string &w : B){
            int size=w.size();
            if(i-(size-1)<0) continue; // that means that string doesnt fit
    //it checks if the substring of s from i-sz+1 to i is equal to w. 
    //If they match and it's possible to break the string up to index i - sz
    //then we set dp[i] to 1 (indicating it's possible to break up to index i) and return true.
            if(A.substr(i-(size-1),size)==w && help(i-size,A,B,dp)){
                dp[i]=1;
                return 1; //true
            }
        }
        //if not false;
        dp[i]=0;
        return dp[i];
    }

    int wordBreak(string A, vector<string> &B) {
        vector<int>dp(A.size(),-1);
        return help(A.size()-1, A,B,dp);
    }
};

    // { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<string> dict;
        for(int i=0;i<n;i++){
            string S;
            cin>>S;
            dict.push_back(S);
        }
        string line;
        cin>>line;
        Solution ob;
        cout<<ob.wordBreak(line, dict)<<"\n";
    }
}

// } Driver Code Ends