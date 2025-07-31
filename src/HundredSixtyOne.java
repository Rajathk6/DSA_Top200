public class HundredSixtyOne {
    public static void main(String[] args) {
        // Problem 161: Smallest Subarray with Sum Greater Than a Given Value
        int[] arr = {1, 4, 45, 6, 0, 19};
        int x = 51;
        int result = smallestSubarray(arr, x);
        System.out.println(result);
    }

    public static int smallestSubarray(int[] arr, int x) {
        int n = arr.length;
        int sum = 0;
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            sum+=arr[i];

            while (sum>x) {
                minLen = Math.min(minLen, i-startIndex+1);
                sum-=arr[startIndex++]; 
            }
        }
        return minLen;
    }
}
