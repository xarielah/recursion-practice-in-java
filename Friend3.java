/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/friend3
 */
public class Friend3 {
    public static void main(String[] args) {
        int[][] mat = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 },
        };
        System.out.println(friend3(mat));
    }

    public static int friend3(int[][] mat) {
        if (mat.length < 3)
            return 0;

        return friend3(mat, 0, 1, 2, 0);
    }

    private static int friend3(int[][] mat, int i, int j, int k, int sum) {
        if (k > mat.length - 1) {
            j++;
            k = j + 1;
        }

        if (j > mat.length - 2) {
            i++;
            j = i + 1;
            k = i + 2;
        }

        if (i > mat.length - 3)
            return sum;

        if (mat[i][j] == 1 && mat[i][k] == 1 && mat[j][k] == 1) {
            sum++;
            System.out.println(i + " " + j + " " + k);
        }

        return friend3(mat, i, j, k + 1, sum);
    }
}
