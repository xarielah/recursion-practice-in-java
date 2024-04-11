/**
 * @see https://kef-code.vercel.app/courses/intro-to-computer-science/recursion/cheapRt
 */
public class CheapRp {
    public static void main(String[] args) {
        System.out.println(cheapRt(new int[] { 2, 4, 8, 3, 10, 1, 12, 3, 2 }, 3, 6, 4));
    }

    public static int cheapRt(int[] stations, int step1, int step2, int limit) {
        if (stations.length < 2)
            return Integer.MAX_VALUE;

        return cheapRt(stations, step1, step2, limit, 0, 0, "");
    }

    private static int cheapRt(int[] stations, int step1, int step2, int limit, int i, int sum, String route) {
        if (i == stations.length - 1) {
            sum += stations[i];
            System.out.println(route + " " + i + " = " + sum);
            return sum;
        }

        if (i > stations.length - 1)
            return Integer.MAX_VALUE;

        int r1 = cheapRt(stations, step1, step2, limit, i + step1, sum + stations[i], route + " " + i + " ");
        int s2 = limit <= 0 ? step1 : step2;
        int r2 = cheapRt(stations, step1, step2, limit - 1, i + s2, sum + stations[i], route + " " + i + " ");

        return r1 > r2 ? r2 : r1;
    }
}
