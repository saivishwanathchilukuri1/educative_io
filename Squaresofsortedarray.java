package ed10;


import java.util.*;

class Squaresofsortedarray {
	public static int[] sortedSquares(int[] nums) {
		// find length of nums
		int n = nums.length;

		// declare an array to store result
		int[] result = new int[n];

		// declare two pointers
		int left = 0;
		int right = n - 1;

		for (int i = n - 1; i >= 0; i--) {
			// comparing absolute values
			// 'square' stores the absolute non-decreasing number in order
			int square;
			if (Math.abs(nums[left]) < Math.abs(nums[right])) {
				square = nums[right];
				right--;
			} else {
				square = nums[left];
				left++;
			}

			// squaring the elements
			result[i] = square * square;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] numsArr = {{-4, -1, 0, 3, 10}, {-7, -3, 2, 3, 11}, {-100, 100}, {-5}, {5}};
		int index = 0;
		for (int[] nums : numsArr) {
			int[] result = sortedSquares(nums);
			System.out.println((++index) + ".\tInput array:   " + Arrays.toString(nums));
			System.out.println("\tSquared array: " + Arrays.toString(result));
			System.out.println(
					"---------------------------------------------------------------------------------------------------\n");
		}
	}
}
