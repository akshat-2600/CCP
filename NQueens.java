import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    // Global list to store all valid board configurations
    private static List<List<String>> result = new ArrayList<>();

    // Checks if it is safe to place a Queen at board[row][col]
    private static boolean isValid(char[][] board, int row, int col) {
        // Look straight up in the same column
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal upwards
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal upwards
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Backtracking method to find solutions row by row
    private static void solve(char[][] board, int row) {
        if (row == board.length) {
            // Found a valid solution, convert char matrix to list of strings
            List<String> validBoard = new ArrayList<>();
            for (char[] r : board) {
                validBoard.add(new String(r));
            }
            result.add(validBoard);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q'; // Place Queen

                solve(board, row + 1); // Recurse to next row

                board[row][col] = '.'; // Backtrack (remove Queen)
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        result.clear(); // Clear previous runs if any
        if (n == 0) {
            return result;
        }

        // Initialize the board with empty cells '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (N): ");
        int n = scanner.nextInt();
        scanner.close();

        List<List<String>> solutions = solveNQueens(n);

        if (solutions.isEmpty()) {
            System.out.println("No solution exists.");
        } else {
            // Print the first valid solution found
            System.out.println("\nA valid solution for " + n + "-Queens:");
            List<String> firstSolution = solutions.get(0);
            for (String row : firstSolution) {
                System.out.println(row);
            }
        }
    }
}
