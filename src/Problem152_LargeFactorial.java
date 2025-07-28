import java.util.*;

public class Problem152_LargeFactorial {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> result = factorial(n);
        Collections.reverse(result);
        for (int digit : result) System.out.print(digit);
    }

    public static List<Integer> factorial(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1); // 0! = 1

        for (int i = 2; i <= n; i++) {
            multiply(res, i);
        }

        return res; // stores in reverse
    }

    private static void multiply(List<Integer> res, int num) {
        int carry = 0;

        for (int i = 0; i < res.size(); i++) {
            int prod = res.get(i) * num + carry;
            res.set(i, prod % 10);      
            carry = prod / 10;        
        }

        while (carry > 0) {
            res.add(carry % 10);
            carry /= 10;
        }
    }
}
