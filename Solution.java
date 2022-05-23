package ed15;
import java.util.*;


public class Solution {
	private int[] original;
	Random rand;

	public void Solution(int[] nums) {
		// TODO: Write - Your - Code
	}

	public int[] reset() {
		// TODO: Write - Your - Code
		return null;
	}

	public int[] shuffle() {
		// TODO: Write - Your - Code
		int[] shuffled = new int[] {};
		return shuffled;
	}

	/* DO NOT CHANGE THE TEST HARNESS CODE BELOW */

	static void print(int[] input) {
		String toPrint = "[";
		for (int i = 0; i < input.length; i++) {
			toPrint += String.valueOf(input[i]) + ", ";
		}
		System.out.print(toPrint.substring(0, toPrint.length() - 2) + "]");
	}

	static void print(double[] input) {
		String toPrint = "[";
		for (int i = 0; i < input.length; i++) {
			toPrint += String.valueOf(input[i]) + ", ";
		}
		System.out.print(toPrint.substring(0, toPrint.length() - 2) + "]");
	}

	static void updateFreqCount(int[] shuffled, int[][] allShuffles, int[] shuffleCounts) {
		for (int i = 0; i < allShuffles.length; i++) {
			if (Arrays.equals(allShuffles[i], shuffled)) {
				shuffleCounts[i]++;
				return;
			}
		}
	}

	static void calcFrequencies(int[] shuffleCounts, double[] shuffleFrequencies,
			double totalTries) {
		for (int i = 0; i < shuffleFrequencies.length; i++) {
			shuffleFrequencies[i] = shuffleCounts[i] / totalTries * 100.0;
		}
	}

	public static void main(String[] args) {

		int[] numsToShuffle = {1, 2, 3};
		int totalTries = 1200;
		Solution sol = new Solution();

		int[][] allShuffles = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
		int[] shuffleCounts = {0, 0, 0, 0, 0, 0};
		double[] shuffleFrequencies = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

		int[] shuffled;
		for (int call = 0; call < totalTries; call++) {
			shuffled = sol.shuffle();
			updateFreqCount(shuffled, allShuffles, shuffleCounts);
		}
		double totalTriesdble = totalTries * 1.0;
		calcFrequencies(shuffleCounts, shuffleFrequencies, totalTriesdble);

		System.out.print("Input array: ");
		print(numsToShuffle);
		System.out.print(", shuffled " + totalTries + " times.\n\n");

		System.out.println("Permutation | Occurrences | Frequency");
		for (int i = 0; i < allShuffles.length; i++) {
			System.out.print(Arrays.toString(allShuffles[i]));
			String sf=String.format("%3d", shuffleCounts[i]);
			System.out.println("   |  \t" + sf + " times | "
					+ String.format("%.02f", shuffleFrequencies[i]) + "%");
		}
	}
}


