//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter ot = new PrintWriter(System.out);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.printUniqueSubsets(nums);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> a,
                        ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            ot.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                ot.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    ot.print(ans.get(i).get(j) + " ");
                ot.print("]");
            }
            ot.println(" ]");
        }
        ot.close();
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public static void findSubsets(int ind, int[] nums, List<Integer> ds, ArrayList<ArrayList<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }

    }

    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }
}