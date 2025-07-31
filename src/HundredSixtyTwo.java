import java.util.Arrays;

public class HundredSixtyTwo {
    public static void main(String[] args) {
        // Problem 162: Three-Way Partitioning of an Array Around a Given Value
        int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int low = 14;
        int high = 20;
        threeWayArray(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    public static void threeWayArray(int[] arr, int lowVal, int highVal) {
        int low=0, mid=0, high = arr.length-1;

        while (mid<=high) {
            if (arr[mid] < lowVal) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] > highVal) {
                swap(arr, mid, high);
                high--;
            } else  {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
