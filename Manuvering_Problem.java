public class EthCode {

    // Returns count of possible paths to reach a cell at row number m 
    // and column number n from the topmost leftmost cell (cell at 1, 1)
    static int numberOfPaths(int m, int n) {
        // If either the given row number or column number is 1, 
        // there is only 1 path to reach it (straight line)
        if (m == 1 || n == 1) {
            return 1;
        }

        // Return the sum of paths from the cell above and the cell to the left
        // (Uncomment the last part if diagonal movements are allowed)
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        // + numberOfPaths(m - 1, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfPaths(3, 3));
    }
}
