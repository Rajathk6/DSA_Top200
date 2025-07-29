import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HundredFiftyFive {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2, 2, 3};
        int k = 2;
        List<Integer> result = majorityElements(arr, k);
        System.out.println(result);
    }

    public static List<Integer> majorityElements(int[] arr, int k) {
        int n = arr.length;
        int threshold = n/k;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) > threshold) {
                result.add(i);
            }
        }
        return result;
    }
}

