public class HundredSixtySeven {
    public static void main(String[] args) {
        // problem 167: Search an Element in a Matrix
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int target = 15;
        boolean result = searchInMatrix(matrix, target);
        System.out.println(result);
    }

    public static boolean searchInMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0; // 0th row
        int col = cols-1; // 3rd column (which makes it the top right element)
        // element to the left of top right is smaller and element down to top right is greater
        while (row<rows && col>=0) {
            if (matrix[row][col] == target) { // if equal return true
                return true;
            } else if (matrix[row][col] > target) { // if element is greater than target skip that col and come left
                col--;
            } else { // if element is not smaller than that element has to be in that column so come down
                row++;
            }
        }
        return false;
    }   
}
