package Coding360.Backtracking.BackTracking;

/*
Problem statement
You are given a starting position for a rat which is stuck in a maze at an initial point (0, 0) (the maze can be thought of as a 2-dimensional plane). The maze would be given in the form of a square matrix of order 'N' * 'N' where the cells with value 0 represent the maze’s blocked locations while value 1 is the open/available path that the rat can take to reach its destination. The rat's destination is at ('N' - 1, 'N' - 1). Your task is to find all the possible paths that the rat can take to reach from source to destination in the maze. The possible directions that it can take to move in the maze are 'U'(up) i.e. (x, y - 1) , 'D'(down) i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).

Note:
Here, sorted paths mean that the expected output should be in alphabetical order.
For Example:
Given a square matrix of size 4*4 (i.e. here 'N' = 4):
1 0 0 0
1 1 0 0
1 1 0 0
0 1 1 1
Expected Output:
DDRDRR DRDDRR
i.e. Path-1: DDRDRR and Path-2: DRDDRR

The rat can reach the destination at (3, 3) from (0, 0) by two paths, i.e. DRDDRR and DDRDRR when printed in sorted order, we get DDRDRR DRDDRR.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
2 <= N <= 5
0 <= MATRIX[i][j] <= 1

Where N is the size of the square matrix.

Time Limit: 1sec
Sample Input 1:
4
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
Sample Output 1:
DDRDRR DRDDRR
Explanation For Sample Input 1:
The rat can reach the destination at (3, 3) from (0, 0) by two paths, i.e. DRDDRR and DDRDRR when printed in sorted order, we get DDRDRR DRDDRR.
Sample Input 2:
2
1 0
1 0
Sample Output 2:
[]
Explanation For Sample Input 2:
As no valid path exists in Sample input 2 so we return an empty list.
 */

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {

    }

    public static ArrayList< String > findSum(int[][] arr, int n) {
        ArrayList<String> paths = new ArrayList<>();

        boolean[][] visited = new boolean[n][n];

        String path = "";

        if(arr[0][0] == 0){
            return paths;
        }

        solve(0,0, arr, n, visited, path, paths);
        return paths;
    }

    private static void solve(int x, int y, int[][] arr, int n, boolean[][] visited, String path, ArrayList<String> paths) {
        if(x == n-1 && y == n-1){
            paths.add(path);
            return;
        }

        visited[x][y] = true;

//      DOWN MOVEMENT
        if(isSafe(x+1, y, n, arr, visited)){
            solve(x+1, y, arr, n, visited, path +'D', paths);
        }


//      LEFT MOVEMENT
        if(isSafe(x, y-1, n, arr, visited)){
            solve(x, y-1, arr, n, visited, path +'L', paths);
        }


//      RIGHT MOVEMENT
        if(isSafe(x, y+1, n, arr, visited)){
            solve(x, y+1, arr, n, visited, path +'R', paths);
        }


//      UP MOVEMENT
        if(isSafe(x-1, y, n, arr, visited)){
            solve(x-1, y, arr, n, visited, path +'U', paths);
        }

        visited[x][y] = false;   // Backtrack
    }

    private static boolean isSafe(int x, int y, int n, int[][] arr, boolean[][] visited) {
        return (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == 1 && !visited[x][y]);
    }
}
