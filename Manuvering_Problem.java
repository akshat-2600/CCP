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



// ------------------------------------------------------------------------------------------


public class UnderwaterDrone {

    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int NONE = 0;

    static void findUnderwaterPath(
            int x,
            int y,
            int prevDir,
            int batteryLeft,
            String path) {

        // Destination reached
        if (x == 3 && y == 3) {
            System.out.println(path + "  Battery used = " + (8 - batteryLeft));
            return;
        }

        // Try moving Right
        if (y + 1 < 4) {

            int cost = 1;

            // If previous direction exists and is different,
            // this move is a turn.
            if (prevDir != NONE && prevDir != RIGHT) {
                cost += 2;
            }

            if (batteryLeft >= cost) {
                findUnderwaterPath(
                        x,
                        y + 1,
                        RIGHT,
                        batteryLeft - cost,
                        path + "R"
                );
            }
        }

        // Try moving Down
        if (x + 1 < 4) {

            int cost = 1;

            // Direction changed -> additional 2 battery
            if (prevDir != NONE && prevDir != DOWN) {
                cost += 2;
            }

            if (batteryLeft >= cost) {
                findUnderwaterPath(
                        x + 1,
                        y,
                        DOWN,
                        batteryLeft - cost,
                        path + "D"
                );
            }
        }
    }

    public static void main(String[] args) {

        findUnderwaterPath(
                0,      // x
                0,      // y
                NONE,   // no previous direction
                8,      // battery
                ""      // path
        );
    }
}