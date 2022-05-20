package ed12;
import java.util.*;
public class quicksort {
	static int partition(int[] arr, int low, int high) {
		// Initializing pivot's index to low
		int pivotValue = arr[low];
		int i = low;
		int j = high;

		// Loop till i pointer crosses j pointer
		while (i < j) {
			// Increment the 'i' pointer till it finds an element greater than pivot
			while (i <= high && arr[i] <= pivotValue)
				i++;
			// Decrement the 'j' pointer till it finds an element less than pivot
			while (arr[j] > pivotValue)
				j--;

			// Swap the numbers on 'i' and 'j'
			if (i < j) {
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
		}
	}

	// Swap pivot element with element on 'j' pointer.
	arr[low] = arr[j];
	arr[j] = pivotValue;

	// return the pivot index
	return j;
}

// Recursive function implementing QuickSort
static void quickSortRec(int[] arr, int low, int high) {
	if (high > low) {
		// pivot_index is the partitioning index
		int pivotIndex = partition(arr, low, high);

		// Sort elements before partition
		quickSortRec(arr, low, pivotIndex - 1);

		// Sort elements after partition
		quickSortRec(arr, pivotIndex + 1, high);
	}
	}

	static void quickSort(int[] arr) {
		quickSortRec(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[][] numsList = {{55, 23, 26, 2, 18, 78, 23, 8, 2, 3}, {1}, {9, 8, 7, 2, 3, 1},
				{10, 20, 30, -1, -2}};

		for (int i = 0; i < numsList.length; i++) {
			System.out.println((i + 1) + ". Before Sorting");
			System.out.println("   " + Arrays.toString(numsList[i]));

			quickSort(numsList[i]);

			System.out.println("   After Sorting");
			System.out.println("   " + Arrays.toString(numsList[i]));
			System.out.println(
					"-----------------------------------------------------------------------------------------------------\n");
		}

		}
	}