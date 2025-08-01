public class HundredSixtyThree {
    public static void main(String[] args) {
        // Problem 163: Minimum Number of Operations to Make an Array Palindrome
        int[] arr = { 1, 4, 5, 1 };
        int result = minOperation(arr);
        System.out.println(result);
    }

    public static int minOperation(int[] arr) {
        int last = arr.length - 1;
        int i = 0;
        int count = 0;
        while (i <= last) {
            if (arr[i] == arr[last]) {
                i++;
                last--;
            } else if (arr[i] < arr[last]) {
                arr[i + 1] += arr[i];
                i++;
                count++;
            } else {
                arr[last - 1] += arr[last];
                last--;
                count++;
            }
        }
        return count;
    }
}
