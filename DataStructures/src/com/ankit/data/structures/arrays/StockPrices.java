package com.ankit.data.structures.arrays;

/**
 * Given a list of stock prices for n days, find the maximum profit with a
 * single buy or sell activity.
 * 
 * @author ankit
 *
 */
public class StockPrices {

	/*
	 * Brute-force method.
	 * Runtime complexity : O(n^2)
	 * Memory complexity : O(1)
	 */
	public static Tuple<Integer, Integer> findBuySellStockPrices(int[] arr) {
		Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(-1, -1);
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int buyPrice = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				int sellPrice = arr[j];
				if (sellPrice - buyPrice > maxProfit) {
					maxProfit = sellPrice - buyPrice;
					result = new Tuple<Integer, Integer>(buyPrice, sellPrice);
				}
			}
		}
		return result;
	}

	/*
	 * Optimized method.
	 * Runtime complexity : O(n) where n is the size of the array.
	 * Memory complexity: O(1) 
	 * 
	 */
	public static Tuple<Integer, Integer> findBuySellStockPrices_Optimized(int[] arr) {
		Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(-1, -1);
		int maxProfit = Integer.MIN_VALUE;
		int curProfit = Integer.MIN_VALUE;
		Integer buyPrice = arr[0];
		Integer sellPrice = null;
		for (int i = 1; i < arr.length; i++) {
			sellPrice = arr[i];
			if (sellPrice - buyPrice > curProfit) {
				curProfit = sellPrice - buyPrice;
			}
			if (curProfit > maxProfit) {
				maxProfit = curProfit;
				result = new Tuple<Integer, Integer>(buyPrice, sellPrice);
				if (sellPrice <= buyPrice) {
					buyPrice = sellPrice;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
		Tuple<Integer, Integer> result = null;
		result = findBuySellStockPrices(array);
		System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));
		result = findBuySellStockPrices_Optimized(array);
		System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

		int[] array2 = { 8, 6, 5, 4, 3, 2, 1 };
		result = findBuySellStockPrices(array2);
		System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));
		result = findBuySellStockPrices_Optimized(array2);
		System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

	}
}

class Tuple<X, Y> {
	public X x;
	public Y y;

	public Tuple(X x, Y y) {
		this.x = x;
		this.y = y;
	}
}
