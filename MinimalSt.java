/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/minimalSt
 */
public class MinimalSt {
    public static void main(String[] args) {
        System.out.println(minimalSt("ABC", "ABCD"));
    }

    public static String minimalSt(String st1, String st2) {
        return minimalSt(st1, st2, "");
    }

    private static String minimalSt(String st1, String st2, String temp) {
        if (st1.equals(""))
            return temp + st2;
        if (st2.equals(""))
            return temp + st1;
        if (st1.charAt(0) == st2.charAt(0)) {
            return minimalSt(st1.substring(1), st2.substring(1), temp + st2.charAt(0));
        }
        String op1 = minimalSt(st1.substring(1), st2, temp + st1.charAt(0));
        String op2 = minimalSt(st1, st2.substring(1), temp + st2.charAt(0));
        return op1.length() < op2.length() ? op1 : op2;
    }
}
