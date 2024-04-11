/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/countPairs
 */
public class CountPairs {
    public static void main(String[] args) {
        System.out.println(countPairs(4));
    }

    public static int countPairs(int n) {
        return countPairs("(", n, 1, 0);
    }

    private static int countPairs(String s, int n, int o, int c) {
        int temp = 0;
        if (c == o && o == n) {
            System.out.println(s);
            return 1;
        }

        if (o < n) {
            temp += countPairs(s + "(", n, o + 1, c);
        }

        if (c < o)
            temp += countPairs(s + ")", n, o, c + 1);

        return temp;
    }
}