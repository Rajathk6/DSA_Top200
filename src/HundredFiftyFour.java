import java.util.Arrays;

public class HundredFiftyFour {
    public static void main(String[] args) {
        // Problem 154: Rearrange Alternating Pos/Neg Elements (O(1) Space)
        int[] arr = {1, 2, 3, -4, -1, 4};
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n;i++) {
            if (i%2==0 && arr[i] >=0 || i%2!=0 && arr[i] < 0) continue;
            
            int j = i+1;
            while (j<n) {
                if (i%2==0 && arr[j] >= 0 || i%2!=0 && arr[j] < 0) break;
                j++;
            }
            
            if (j==n) break;

            int temp = arr[j];
            for (int k = j; k>i; k--) {
                arr[k] = arr[k-1];
            }
            arr[i] = temp;
        }
    }
}
