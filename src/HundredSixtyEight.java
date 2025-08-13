public class HundredSixtyEight {
    public static void main(String[] args) {
        // problem 168: find medan in a row-wise sorted matrix
        int[][] matrix = {
            {1,3,5},
            {2,6,9},
            {3,6,9}
        };

        int result = medianSortedMatrix(matrix);
        System.out.println(result);
    }

    public static int medianSortedMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            minVal = Math.min(minVal, matrix[i][0]);
            maxVal = Math.max(maxVal, matrix[i][c - 1]);
        }

        int desired = (r * c + 1) / 2;

        while (minVal < maxVal) {
            int mid = minVal + (maxVal - minVal) / 2;
            int count = 0;

            // Count elements <= mid
            for (int i = 0; i < r; i++) {
                count += countLessOrEqual(matrix[i], mid);
            }

            if (count < desired) {
                minVal = mid + 1;
            } else {
                maxVal = mid;
            }
        }
        return minVal;
    }

    private static int countLessOrEqual(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low; // count of elements <= target
    }
}
