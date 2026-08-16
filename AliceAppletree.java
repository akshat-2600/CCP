import java.util.Scanner;

class Main {

    /*
     * Returns the minimum number of apples that need to be collected
     * to guarantee at least M red apples.
     *
     * M = Number of red apples required
     * K = Number of apples available on each tree
     * N = Number of trees in North
     * S = Number of trees in South
     * W = Number of trees in West
     * E = Number of trees in East
     */
    static int minimumApples(int requiredRedApples,
                             int applesPerTree,
                             int northTrees,
                             int southTrees,
                             int westTrees,
                             int eastTrees) {

        /*
         * SOUTH:
         *
         * Every apple from a South tree is RED.
         *
         * Therefore, if we have enough red apples in the South,
         * we only need to collect the required number of apples.
         *
         * Total guaranteed red apples from South:
         *
         * southTrees * applesPerTree
         */
        int guaranteedRedFromSouth =
                southTrees * applesPerTree;

        if (requiredRedApples <= guaranteedRedFromSouth) {

            // We can get all required red apples from South.
            return requiredRedApples;
        }


        /*
         * WEST and EAST:
         *
         * These trees contain both red and green apples.
         *
         * Since we cannot distinguish the colors,
         * we can guarantee only 1 red apple from each tree.
         *
         * Therefore:
         *
         * Guaranteed red apples from West = westTrees
         * Guaranteed red apples from East = eastTrees
         */
        int guaranteedRedFromMixedTrees =
                westTrees + eastTrees;


        /*
         * Check whether South + West + East
         * can provide enough guaranteed red apples.
         */
        if (requiredRedApples <=
                guaranteedRedFromSouth + guaranteedRedFromMixedTrees) {

            /*
             * We already collect all apples from South.
             *
             * Remaining red apples required:
             *
             * requiredRedApples - guaranteedRedFromSouth
             *
             * From West/East, each tree guarantees only 1 red apple,
             * so we need exactly that many additional apples.
             */
            int remainingRedApples =
                    requiredRedApples - guaranteedRedFromSouth;

            return guaranteedRedFromSouth + remainingRedApples;
        }


        /*
         * NORTH contains only green apples.
         *
         * Therefore, North cannot help us guarantee any red apples.
         *
         * If South + West + East are still insufficient,
         * getting M red apples is impossible.
         */
        return -1;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Number of red apples required.
        System.out.print("Enter number of apples to be collected: ");
        int requiredRedApples = scanner.nextInt();

        // Number of apples available on each tree.
        System.out.print("Enter number of apples in each tree: ");
        int applesPerTree = scanner.nextInt();

        // Number of trees in each direction.
        System.out.print("Enter number of trees in North: ");
        int northTrees = scanner.nextInt();

        System.out.print("Enter number of trees in South: ");
        int southTrees = scanner.nextInt();

        System.out.print("Enter number of trees in West: ");
        int westTrees = scanner.nextInt();

        System.out.print("Enter number of trees in East: ");
        int eastTrees = scanner.nextInt();


        // Find the minimum number of apples to collect.
        int result = minimumApples(
                requiredRedApples,
                applesPerTree,
                northTrees,
                southTrees,
                westTrees,
                eastTrees
        );

        System.out.println("Minimum apples to collect: " + result);

        scanner.close();
    }
}