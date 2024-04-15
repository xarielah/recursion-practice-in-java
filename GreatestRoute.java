/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/greatestRoute
 */
public class GreatestRoute {
    public static void main(String[] args) {
        int[][] mat = {
                { 2, 3 },
                { 4, 1 }
        };

        System.out.println(greatestRoute(mat));
    }

    public static int greatestRoute(int[][] mat) {
        return greatestRoute(mat, 0, 0, 0, "", new int[mat.length][mat[0].length]);
    }

    private static int greatestRoute(int[][] mat, int i, int j, int sum, String s, int[][] count) {
        if (i < 0 || j < 0 || j > mat[0].length - 1 || i > mat.length - 1 || count[i][j] >= mat[i][j])
            return Integer.MIN_VALUE;

        if (i == mat.length - 1 && j == mat[0].length - 1) {
            sum += mat[i][j];
            s += "(" + i + ", " + j + ") = " + sum;
            System.out.println(s);
            return sum;
        }

        count[i][j]++;

        int up = greatestRoute(mat, i - 1, j, sum + mat[i][j], s + "(" + i + ", " + j + ") --> ", count);
        int right = greatestRoute(mat, i, j + 1, sum + mat[i][j], s + "(" + i + ", " + j + ") --> ", count);
        int down = greatestRoute(mat, i + 1, j, sum + mat[i][j], s + "(" + i + ", " + j + ") --> ", count);
        int left = greatestRoute(mat, i, j - 1, sum + mat[i][j], s + "(" + i + ", " + j + ") --> ", count);

        count[i][j]--;

        return Math.max(Math.max(up, right), Math.max(down, left));
    }
}
