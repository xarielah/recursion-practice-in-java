/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/findWord
 */
public class FindWord {
    public static void main(String[] args) {
        char[][] arr = {
                { 't', 'z', 'x', 'c', 'd' },
                { 's', 'h', 'a', 'x', 'z' },
                { 'h', 'w', 'l', 'o', 'm' },
                { 'o', 'r', 'n', 't', 'n' },
                { 'a', 'b', 'r', 'i', 'n' }
        };
        findWord(arr, "shalom");
    }

    /**
     * Driver method, it'll call a helper method.
     */
    public static void findWord(char[][] arr, String word) {
        int[][] track = new int[arr.length][arr[0].length];
        findWord(arr, word, track, 0, 0, false);
    }

    private static void printArr(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println();
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
                if (j != a[i].length - 1)
                    System.out.print(" | ");
                else
                    System.out.println("");
            }
            if (i != a.length - 1)
                System.out.println("- - - - - - - - - - -");
        }
    }

    /**
     * Helper method that'll be used to iterate the matrix with a right-down
     * movement,
     * the other function will search up, right, down, left
     */
    private static int findWord(char[][] arr, String word, int[][] track, int i, int j, boolean done) {
        if (done == true)
            return 1;

        if (j >= arr.length)
            return 0;
        if (i >= arr.length)
            return 1;

        if (findWord(arr, word, track, i, j, 0)) {
            done = true;
            printArr(track);
            return 1;
        }

        if (findWord(arr, word, track, i, j + 1, done) == 1) {
            return 1;
        }
        return findWord(arr, word, track, i + 1, 0, false);
    }

    /**
     * Method will be taking a position in the matrix, and circle around the
     * position to find
     * if next charater of a giver string is within these 4 steps (up, right, down,
     * left)
     */
    private static boolean findWord(char[][] arr, String word, int[][] track, int i, int j, int stringIndex) {
        if (stringIndex == word.length())
            return true;

        if (i < 0 || j < 0 || i == arr.length || j == arr[0].length)
            return false;

        if (arr[i][j] == word.charAt(stringIndex)) {
            track[i][j] = stringIndex + 1;
            boolean up = findWord(arr, word, track, i - 1, j, stringIndex + 1);
            boolean right = findWord(arr, word, track, i, j + 1, stringIndex + 1);
            boolean down = findWord(arr, word, track, i + 1, j, stringIndex + 1);
            boolean left = findWord(arr, word, track, i, j - 1, stringIndex + 1);
            if (up || right || down || left) {
                return true;
            } else {
                track[i][j] = 0;
                return false;
            }
        }
        return false;
    }

}
