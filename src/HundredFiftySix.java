public class HundredFiftySix {
    public static void main(String[] args) {
        // Problem 156: Best Time to Buy and Sell Stock — At Most Two Transactions
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        if (n<2) return 0;

        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];
        
        int minPrices = prices[0];
        for (int i=1; i<n; i++) {
            minPrices = Math.min(minPrices, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i] - minPrices);
        }

        int maxPrice = prices[n-1];
        for (int i=n-2; i>0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i+1], maxPrice - prices[i]);
        }

        int maxProfit = 0;
        for (int i=0; i<n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }
        return maxProfit;
    }
}
