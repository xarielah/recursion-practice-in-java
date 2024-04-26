/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/totalWays
 */
public class TotalWays {
    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        System.out.println(totalWays(mat, 1)); // 2
        System.out.println(totalWays(mat, 2)); // 2
        System.out.println(totalWays(mat, 3)); // 2
        System.out.println(totalWays(mat, 4)); // 0
    }

    public static int totalWays(int[][] mat, int k) {
        return totalWays(mat, k, 0, 0, 0, ' ');
    }

    private static int totalWays(int[][] mat, int k, int i, int j, int turns,
            char step) {
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return turns == k ? 1 : 0;
        }
        if (i >= mat.length || j >= mat[0].length)
            return 0;
        int rTurns = step == 'd' ? turns + 1 : turns;
        int dTurns = step == 'r' ? turns + 1 : turns;
        return totalWays(mat, k, i, j + 1, rTurns, 'r') + totalWays(mat, k, i + 1, j,
                dTurns, 'd');
    }
}
