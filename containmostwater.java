package ed11;
import java.util.*;

public class containmostwater {
	public static int maxWaterAreaContainer(int[] height) {
		// Initialize maxArea as zero and the left and right markers to the two ends
		// of an array
		int maxArea = 0, left = 0, right = height.length - 1;
		
		while (left < right) {
			// Calculating the max area using the shortest height and the
			// length of x-axis between the two heights
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			
			// Move the left bar if it has the shorter height
			if (height[left] < height[right])
				left++;
			// Otherwise move the right bar
			else
				right--;
		}

		// Return the maximum area container
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] inputList = {{1, 8, 6, 2, 5, 4, 8, 3, 7}, {20, 30, 9, 69}, {13, 18, 12, 8},
				{45, 32, 56, 99}, {23, 20}};
		int index = 0;
		for (int[] input : inputList) {
			System.out.println((++index) + ". maxWaterAreaContainer(" + Arrays.toString(input) + "): "
					+ maxWaterAreaContainer(input));
			System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
		}
	}
	}


