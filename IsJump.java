/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/isJump
 */
public class IsJump {
    public static void main(String[] args) {
        System.out.println(isJump("abcfbaagcxabcd", "abc", 1));
    }

    public static boolean isJump(String str1, String str2, int step) {
        if (str2.equals(""))
            return true;

        if (str1.length() < str2.length() || step > str1.length())
            return false;

        if (str1.charAt(0) == str2.charAt(0))
            return isJump(str1.substring(step), str2.substring(1), step);

        return false;
    }
}
