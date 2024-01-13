class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    public boolean isSafe(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
            return false;
        return true;
    }

    public int minimumCostPath(int[][] grid) {
        // Code here
        int n = grid.length, m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));

        pq.add(new Pair(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int currow = curr.row;
            int currcol = curr.col;
            int currdist = curr.dist;

            for (int i = 0; i < 4; i++) {
                int newr = currow + dr[i];
                int newc = currcol + dc[i];

                if (isSafe(grid, newr, newc)) {
                    if (grid[newr][newc] + currdist < dist[newr][newc]) {
                        dist[newr][newc] = grid[newr][newc] + currdist;
                        pq.add(new Pair(newr, newc, dist[newr][newc]));
                    }
                }
            }

        }
        return dist[n - 1][m - 1];
    }
}