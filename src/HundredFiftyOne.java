import java.util.HashSet;
import java.util.Set;

public class HundredFiftyOne {
    public static void main(String[] args) {
        // Problem 151: Find if There Is Any Subarray with Sum Equal to 0
        int[] arr = {4,2,-3,1,6};
        boolean result = hasZeroSumSubarray(arr);
        System.out.println(result);
    }

    public static boolean hasZeroSumSubarray(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;

            if (seen.contains(prefixSum) || prefixSum==0) {
                return true;
            }
            seen.add(prefixSum);
        }
        return false;
    }
}
