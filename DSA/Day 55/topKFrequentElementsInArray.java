
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        int[] Store_Kelement = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> (a.first == b.first) ? (a.second - b.second) : (a.first - b.first));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int j = k - 1;
        while (pq.size() > 0) {
            Store_Kelement[j--] = pq.poll().second;
        }

        return Store_Kelement;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}