
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class meeting {
    int start;
    int end;
    int pos;

    public meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        ArrayList<meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new meeting(start[i], end[i], i + 1));
        Collections.sort(list, (a, b) -> {
            if (a.end < b.end)
                return a.end - b.end;
            else if (a.end == b.end)
                return a.pos - b.pos;
            return 1;
        });
        int count = 1, limit = list.get(0).end;
        for (int i = 1; i < n; i++) {
            if (list.get(i).start > limit) {
                limit = list.get(i).end;
                count++;
            }
        }
        return count;
    }
}
