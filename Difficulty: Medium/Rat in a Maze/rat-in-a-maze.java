import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] == 0 || maze[n-1][n-1] == 0) return res; // no path if start/end blocked
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, "", res, visited);
        Collections.sort(res);
        return res;
    }
    
    private void solve(int i, int j, int[][] maze, int n, String path, ArrayList<String> res, boolean[][] visited) {
        // base case: reached destination
        if (i == n - 1 && j == n - 1) {
            res.add(path);
            return;
        }
        
        visited[i][j] = true;
        
        // move Down
        if (isSafe(i + 1, j, maze, n, visited))
            solve(i + 1, j, maze, n, path + 'D', res, visited);
        
        // move Left
        if (isSafe(i, j - 1, maze, n, visited))
            solve(i, j - 1, maze, n, path + 'L', res, visited);
        
        // move Right
        if (isSafe(i, j + 1, maze, n, visited))
            solve(i, j + 1, maze, n, path + 'R', res, visited);
        
        // move Up
        if (isSafe(i - 1, j, maze, n, visited))
            solve(i - 1, j, maze, n, path + 'U', res, visited);
        
        visited[i][j] = false; // backtrack
    }
    
    private boolean isSafe(int i, int j, int[][] maze, int n, boolean[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j])
    


        ;
    }
}
