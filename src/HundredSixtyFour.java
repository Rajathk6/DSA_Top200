public class HundredSixtyFour {
    public static void main(String[] args) {
        // Problem 164: Median of Two Sorted Arrays of Equal Size
        int[] arr1 = { 1, 3, 8 };
        int[] arr2 = { 2, 7, 10 };

        double result = medianSortedArray(arr1, arr2);
        System.out.println(result);
    }

    public static double medianSortedArray(int[] a, int[] b) {
        //O(Log N)
        int n = a.length;

        int low = 0, high = n;

        while (low <= high) {
            int midA = (low + high) / 2;
            int midB = n - midA;

            int maxLeftA = (midA == 0) ? Integer.MIN_VALUE : a[midA - 1];
            int maxLeftB = (midB == 0) ? Integer.MIN_VALUE : b[midB - 1];
            int minRightA = (midA == n) ? Integer.MAX_VALUE : a[midA];
            int minRightB = (midB == n) ? Integer.MAX_VALUE : b[midB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                return (Math.min(minRightA, minRightB) + Math.max(maxLeftA, maxLeftB))/2.0;
            } else if (maxLeftA > minRightB) {
                high = midA-1;
            } else {
                low = midA+1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or valid.");
    }
}

// O (N)
// public static double medianSortedArray(int[] arr1, int[] arr2) {
// int i=0, j=0;
// int m1=-1, m2=-1;
// int n = arr1.length;

// for (int count=0; count<=n; count++) {
// if (i!=n && (j==n || arr1[i] <= arr2[j])) {
// m1 = m2;
// m2 = arr1[i++];
// } else {
// m1 = m2;
// m2 = arr2[j++];
// }
// }
// return (m1+m2)/2.0;
// }