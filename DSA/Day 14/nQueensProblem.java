//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        int[] board = new int[n];
        solveNQueens(0, n, board, solutions);
        return solutions;
    }

    private static void solveNQueens(int row, int n, int[] board, ArrayList<ArrayList<Integer>> solutions) {
        if (row == n) {
            solutions.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPlacement(board, row, col)) {
                board[row] = col;
                solveNQueens(row + 1, n, board, solutions);
            }
        }
    }

    private static boolean isValidPlacement(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> constructSolution(int[] board) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int col : board) {
            solution.add(col + 1);
        }
        return solution;
    }
}