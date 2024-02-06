//{ Driver Code Starts
    #include <bits/stdc++.h>
    using namespace std;
    
    
    int stringComparsion(string s1, string s2);
    
    
    int main() 
    {
    
    
           ios_base::sync_with_stdio(0);
        cin.tie(NULL);
        cout.tie(NULL);
       
           int t;
           cin >> t;
           while(t--)
           {
               string s1, s2;
               cin >> s1 >> s2;
    
               
               cout << stringComparsion(s1, s2) << "\n";
           }
    
        return 0;
    }
    
    // } Driver Code Ends
    
    
    
    int stringComparsion(string s1,string s2)
    {
        // Your code goes here
        for(int i=0;i<s1.length();i++){
            if(s1[i]>s2[i])
            return 1;
            else if(s1[i]<s2[i])
               return -1;
               else{
                   if(s1[i]=='n'&&s1[i+1]=='g'&&s2[i+1]!='g')
                   return 1;
                   if(s2[i]=='n'&&s2[i+1]=='g'&&s1[i+1]!='g')
                   return -1;
               }
        }
        // if(s1.length()>s2.length()) return 1;
        if(s1.length()<s2.length()) return -1;
         return 0;
    }