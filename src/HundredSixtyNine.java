public class HundredSixtyNine {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1}
        };

        int rowIndex = findRowWithMaxOnes(matrix);
        System.out.println("Row with maximum 1s is: " + rowIndex);
    }

    public static int findRowWithMaxOnes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxRowIndex = -1;
        int j = m - 1; // start from top-right corner

        for (int i = 0; i < n; i++) {
            while (j >= 0 && matrix[i][j] == 1) {
                j--; // move left if we see 1
                maxRowIndex = i; // update row index
            }
        }

        return maxRowIndex;
    }
}
