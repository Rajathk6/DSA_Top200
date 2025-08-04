public class HundredSixtyFive {
    public static void main(String[] args) {
        // Problem 165: Median of two sorted arrays of different sizes
        int[] num1 = {1,3};
        int[] num2 = {2};
        double result = medianDifferentSize(num1, num2);
        System.out.println(result);
    }

    public static double medianDifferentSize(int[] A, int[] B) {
        if (A.length > B.length) {
            return medianDifferentSize(B, A);
        }
        int m = A.length;
        int n = B.length;
        int low = 0, high = m;

        while (low<=high) {
            int midA = (low+high)/2;
            int midB = (m+n+1)/2 - midA;

            int maxLeftA = (midA == 0) ? Integer.MIN_VALUE : A[midA-1];
            int minRightA = (midA == m) ? Integer.MAX_VALUE : A[midA];
            int maxLeftB = (midB == 0) ? Integer.MIN_VALUE : B[midB-1];
            int minRightB = (midB == n) ? Integer.MAX_VALUE : B[midB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m+n)%2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = midA-1;
            } else {
                low = midA+1;
            }
        }
        throw new IllegalArgumentException("Array not sorted"); 
    }
}
