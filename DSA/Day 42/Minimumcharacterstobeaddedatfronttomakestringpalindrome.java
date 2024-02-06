//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public static int minChar(String str) {
        int N = str.length();
        String reversedStr = new StringBuilder(str).reverse().toString();
        String modifiedStr = str + "$" + reversedStr;
        int[] lps = new int[2 * N + 1];
        computeLPSArray(modifiedStr, lps);
        return N - lps[2 * N];
    }
    private static void computeLPSArray(String str, int[] lps) {
        int N = str.length();
        int len = 0;  
        
        int i = 1;
        while (i < N) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.minChar(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}
// } Driver Code Ends