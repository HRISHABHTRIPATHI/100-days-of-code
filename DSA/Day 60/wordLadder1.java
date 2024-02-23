
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    // Method to check if two strings are one character away
    private boolean isOneCharAway(String str1, String str2) {
        int diffChar = 0;
        for (int k = 0; k < str1.length(); k++) {
            if (str1.charAt(k) != str2.charAt(k)) {
                diffChar += 1;
            }

            if (diffChar > 1) {
                break;
            }
        }
        return diffChar == 1;
    }

    // This will create a edge between words
    private void addEdge(Map<String, ArrayList<String>> graph, String from, String to) {
        if (graph.containsKey(from)) {
            graph.get(from).add(to);
        } else {
            ArrayList list = new ArrayList<String>();
            list.add(to);
            graph.put(from, list);
        }
    }

    public Map<String, ArrayList<String>> buildGraph(String startWord, String[] wordList) {

        Map<String, ArrayList<String>> graph = new HashMap<>();
        for (int i = 0; i < wordList.length; i++) {
            for (int j = i + 1; j < wordList.length; j++) {

                if (isOneCharAway(wordList[i], wordList[j])) {
                    addEdge(graph, wordList[i], wordList[j]);
                    addEdge(graph, wordList[j], wordList[i]);
                }
            }
        }

        for (int i = 0; i < wordList.length; i++) {

            if (isOneCharAway(wordList[i], startWord)) {
                addEdge(graph, wordList[i], startWord);
                addEdge(graph, startWord, wordList[i]);
            }
        }
        return graph;
    }

    public class Node {
        String val;
        int dist;

        public Node(int dist, String val) {
            this.val = val;
            this.dist = dist;
        }
    }

    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Map<String, ArrayList<String>> graph = buildGraph(startWord, wordList);

        if (graph.isEmpty()) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        Node startNode = new Node(1, startWord);
        queue.add(startNode);
        visited.add(startWord);

        while (!queue.isEmpty()) {
            Node node = queue.peek();
            queue.remove();

            if (graph.get(node.val) == null) {
                return 0;
            }

            for (String adjs : graph.get(node.val)) {
                if (adjs.equals(targetWord)) {
                    return node.dist + 1;
                }

                if (!visited.contains(adjs)) {
                    Node currNode = new Node(node.dist + 1, adjs);
                    visited.add(adjs);
                    queue.add(currNode);
                }
            }
        }

        return 0;
    }
}