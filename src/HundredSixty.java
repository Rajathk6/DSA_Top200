import java.util.Arrays;

public class HundredSixty {
    public static void main(String[] args) {
        // Problem 160: Chocolate Distribution Problem
        int[] arr = {7, 3, 2, 5, 9, 12, 56};
        int m = 3;
        int result = minMaxDiff(arr, m);
        System.out.println(result);
    }

    public static int minMaxDiff(int[] arr, int m) {
        if (m==0 || arr.length == 0) return 0;

        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i=0; i+m-1 < arr.length; i++) {
            int diff = arr[i+m-1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
