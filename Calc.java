/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/calc
 */
public class Calc {
    public static void main(String[] args) {
        System.out.println(calc(3, 36, 5));
    }

    public static int calc(int num, int result, int maxOp) {
        if (maxOp <= 0)
            return 0;
        return calc(num, result, maxOp, num, "" + num);
    }

    private static int calc(int n, int r, int m, int t, String s) {
        if (m < 0 || t > r)
            return 0;

        if (t == r) {
            System.out.println(s + " = " + r);
            return 1;
        }

        int add = calc(n, r, m - 1, t + n, s + " + " + n);
        int mul = calc(n, r, m - 1, t * n, s + " * " + n);
        int div = calc(n, r, m - 1, t / n, s + " / " + n);
        int sub = calc(n, r, m - 1, t - n, s + " - " + n);

        return add + mul + sub + div;
    }
}