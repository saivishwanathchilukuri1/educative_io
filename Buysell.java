
package ed6;
import java.util.*;
class Tuple<X, Y> {
	public X x;
	public Y y;

	public Tuple(X x, Y y) {
		this.x = x;
		this.y = y;
	}
}
class Buysell {
	public static Tuple<Integer, Integer> findBuySellStockPrices(int[] stockNums) {
		// Return None when stock list is empty or less than 2
		if (stockNums == null || stockNums.length < 2) {
			return null;
		}

		// Initializations
		int currentBuy = stockNums[0];
		int globalSell = stockNums[1];

		// Calculating the global profit
		int globalProfit = globalSell - currentBuy;

		// Initializing currentProfit with minimum value
		int currentProfit = Integer.MIN_VALUE;

		// Looping over stocks to find best buy and selling price
		for (int i = 1; i < stockNums.length; i++) {
			// Calculating the current profit
			currentProfit = stockNums[i] - currentBuy;

			// Current profit is greater than the global profit
			if (currentProfit > globalProfit) {
				globalProfit = currentProfit;
				globalSell = stockNums[i];
			}

			// We will always maximise margin relative to the lowest stock price we can find
			// So whenever we find a stock price lower than the current buying price,
			// we adopt it as the current buying price
			if (currentBuy > stockNums[i]) {
				currentBuy = stockNums[i];
			}
		}

		// Tuple having buy price and sell price
		Tuple<Integer, Integer> result =
				new Tuple<Integer, Integer>(globalSell - globalProfit, globalSell);

		return result;
	}

	public static void main(String[] args) {

		int[][] stockPricesData =
				{{1, 2, 3, 4, 3, 2, 1, 2, 5}, {8, 6, 5, 4, 3, 2, 1}, {12, 30, 40, 90, 110}, {2}};

		for (int i = 0; i < stockPricesData.length; i++) {
			Tuple<Integer, Integer> result = findBuySellStockPrices(stockPricesData[i]);
			System.out.println((i + 1) + ". Day stocks: " + Arrays.toString(stockPricesData[i]));
			if (result != null) {
				System.out.println("   Buy Price: " + result.x + ", Sell Price: " + result.y);
			} else {
				System.out.println("   Buy Price: null, Sell Price: null");
			}
			System.out.println(
					"-------------------------------------------------------------------------------------------------------\n");
		}
	}
}

