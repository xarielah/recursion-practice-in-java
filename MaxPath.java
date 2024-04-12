/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/maxPath
 */
public class MaxPath {
    public static void main(String[] args) {
        int[][] mat = {
                { 12, 22, 23, 54, 11 },
                { 43, 35, 21, 20, 30 },
                { 34, 23, 43, 22, 30 },
                { 25, 31, 2, 20, 34 },
                { 10, 22, 10, 11, 10 },
                { 40, 13, 3, 1, 23 }
        };
        System.out.println(maxPath(mat));
    }

    public static int maxPath(int[][] mat) {
        if (mat.length == 0)
            return 0;
        return maxPath(mat, 0, 0, 0, "");
    }

    private static int maxPath(int[][] mat, int i, int j, int sum, String result) {
        if (i > mat.length - 1 || j > mat[0].length - 1)
            return Integer.MIN_VALUE;

        if (i == mat.length - 1 && j == mat[0].length - 1) {
            sum += mat[i][j];
            result += "[" + i + ", " + j + "] = " + mat[i][j];
            System.out.println(result + " = " + sum);
            return sum;
        }

        int step1 = mat[i][j] % 10;
        int step2 = mat[i][j] / 10;

        int r1 = maxPath(mat, i + step1, j + step2, sum + mat[i][j],
                result + "[" + i + ", " + j + "] = " + mat[i][j] + " ");
        int r2 = maxPath(mat, i + step2, j + step1, sum + mat[i][j],
                result + "[" + i + ", " + j + "] = " + mat[i][j] + " ");

        return Math.max(r1, r2);
    }
}
