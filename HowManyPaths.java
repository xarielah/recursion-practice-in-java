/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/howManyPaths
 */
public class HowManyPaths {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 3, 1, 6 },
                { 2, 8, 1, 2 },
                { 6, 2, 7, 5 },
                { 2, 4, 1, 3 },
        };
        System.out.println(howManyPaths(mat)); // 2
    }

    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    private static int howManyPaths(int[][] mat, int i, int j) {
        if (i == mat.length - 1 && j == mat[0].length - 1)
            return 1;
        if (i >= mat.length || j >= mat[0].length || j < 0 || i < 0 || mat[i][j] == 0)
            return 0;
        int k = mat[i][j];
        mat[i][j] = 0;
        int optSum = howManyPaths(mat, i + k, j)
                + howManyPaths(mat, i - k, j)
                + howManyPaths(mat, i, j + k)
                + howManyPaths(mat, i, j - k);
        mat[i][j] = k;
        return optSum;
    }
}
