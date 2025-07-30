import java.util.HashSet;
import java.util.Set;

public class HundredFiftyEight {
    public static void main(String[] args) {
        // Problem 158: Longest Consecutive Subsequence
        int[] arr = { 10, 5, 12, 3, 55, 30, 11, 13 };
        int result = longestConsecutive(arr);
        System.out.println(result);
    }

    public static int longestConsecutive(int[] arr) {
        // o(n)
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;

        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }
                maxCount = Math.max(maxCount, streak);
            }
        }
        return maxCount;
    }
}

// O(n log n)
// public static int longestConsecutive(int[] arr) {
// Arrays.sort(arr);

// int count = 1, maxCount = 1;

// for (int i = 1; i < arr.length; i++) {
// if (arr[i] == arr[i - 1])
// continue;
// if (arr[i] == arr[i - 1] + 1)
// count++;
// else
// count = 1;

// maxCount = Math.max(count, maxCount);
// }

// return maxCount;
// }