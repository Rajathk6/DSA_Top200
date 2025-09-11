import java.util.PriorityQueue;

class Element {
    int value;
    int row;
    int col;

    Element(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}

public class HundredSeventy {
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };

        printSorted(matrix);
    }

    public static void printSorted(int[][] matrix) {
        int n = matrix.length;

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // insert first element of each row
        for (int i = 0; i < n; i++) {
            minHeap.add(new Element(matrix[i][0], i, 0));
        }

        while (!minHeap.isEmpty()) {
            Element curr = minHeap.poll();
            System.out.print(curr.value + " ");

            int nextCol = curr.col + 1;
            if (nextCol < n) {
                minHeap.add(new Element(matrix[curr.row][nextCol], curr.row, nextCol));
            }
        }
    }
}
