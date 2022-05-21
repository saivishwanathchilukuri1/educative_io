package ed13;
import java.util.*;

public class sortcolors {
	public static void sortColors(int[] arr) {
		// Start element of array
		int start = 0;
		// Current element of aaray
		int current = 0;
		// Last element of array
		int end = arr.length - 1;

		int tmp;

		while (current <= end) {
			if (arr[current] == 0) {
				// Swap the elements at start and current indexes
				// Increment start and current indexes by one
				tmp = arr[start];
				arr[start++] = arr[current];
				arr[current++] = tmp;
			} else if (arr[current] == 2) {
				// Swap the elements at end and current indexes

}
			tmp = arr[current];
			arr[current] = arr[end];
			arr[end--] = tmp;
		} 
		else
			// Simply increment the current index if it is pointing to 1
			current++;
	}
}

public static void main(String[] args) {
	int[][] inputs = {{2, 0, 2, 1, 1, 0}, {2, 0, 1}, {2, 0, 2, 1, 1, 0, 1, 0, 1, 0, 2}};
	int index = 0;
	for (int[] input : inputs) {
		System.out.println((++index) + ". Unsorted colors: " + Arrays.toString(input));
		sortColors(input);
		System.out.println("   Sorted colors:   " + Arrays.toString(input));
		System.out.println("----------------------------------------------------------------");
	}
}
}

