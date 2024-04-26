/**
 * @see
 */
public class MinDiff {
    public static void main(String[] args) {
        System.out.println(minDiff(new int[] { 5, 2, 4 })); // 1
        System.out.println(minDiff(new int[] { 1, 2, 3 })); // 0
        System.out.println(minDiff(new int[] { 1, 2, 7, 17, 6 })); // 1
    }

    private static int minDiff(int[] arr, int i, int sumA, int sumB) {
        if (i == arr.length)
            return Math.abs(sumA - sumB);
        int o1 = minDiff(arr, i + 1, sumA + arr[i], sumB);
        int o2 = minDiff(arr, i + 1, sumA, sumB + arr[i]);
        return Math.min(o1, o2);
    }

    public static int minDiff(int[] arr) {
        return minDiff(arr, 0, 0, 0);
    }
}
