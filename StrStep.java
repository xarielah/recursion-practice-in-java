/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/isJump
 */
public class StrStep {
    public static void main(String[] args) {
        System.out.println(strStep("abcfbaagcxabcd", "abc"));
    }

    public static int strStep(String str1, String str2) {
        return strStep(str1, str2, 1, "", 0, 0);
    }

    private static int strStep(String str1, String str2, int step, String str3, int i, int j) {
        if (str2.equals(str3))
            return step;

        if (i > str1.length() - 1 || j > str2.length() - 1 || step > str1.length() - 1)
            return -1;

        if (str1.charAt(i) != str2.charAt(j))
            return strStep(str1, str2, step + 1, "", 0, 0);

        return strStep(str1, str2, step, str3 + str2.charAt(j), i + step, j + 1);
    }
}