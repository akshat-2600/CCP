public class RatMaze {
    // Size of the maze (N x N)
    private final int N = 4; 

    // Helper method to print the solution matrix
    void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    } 

    // Utility function to check if x, y is a valid move
    boolean isSafe(int[][] maze, int x, int y) {
        // Must be within boundaries and pointing to an open path (1)
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Wrapper function to initialize and trigger the solver
    boolean solveMaze(int[][] maze) {
        int[][] sol = { 
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 } 
        }; 

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
            return false;
        } 

        printSolution(sol);
        return true;
    } 

    // Core backtracking recursive function
    boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        // Base Case: If the rat reaches the bottom-right destination
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if the current cell is safe to step into
        if (isSafe(maze, x, y)) {
            // Choose: Mark current cell as part of the solution path
            sol[x][y] = 1;

            // Explore: Move Downwards (x + 1)
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true; 
            }

            // Explore: Move Rightwards (y + 1)
            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true; 
            }

            // Un-choose (Backtrack): If neither direction works, unmark this cell
            sol[x][y] = 0;
            return false;
        } 

        return false;
    } 

    public static void main(String[] args) {
        RatMaze rat = new RatMaze();
        int[][] maze = { 
            { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } 
        };
        rat.solveMaze(maze);
    }
}
