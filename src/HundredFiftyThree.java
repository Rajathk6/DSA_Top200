import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HundredFiftyThree {
    public static void main(String[] args) {
        // Problem 153: Find Common Elements in Three Sorted Arrays
        int[] a = { 1, 1, 2, 3 };
        int[] b = { 1, 1, 3, 4 };
        int[] c = { 1, 1, 3, 5 };
        List<Integer> result = findCommonElements(a, b, c);
        System.out.println(result);
    }

    public static List<Integer> findCommonElements(int[] A, int[] B, int[] C) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i : A) set.add(i);

        for (int i : B) if (set.contains(i)) set1.add(i);

        for (int i : C) if (set1.contains(i)) result.add(i);

        return new ArrayList<>(result);
    }
}
