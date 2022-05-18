package ed9;
import java.util.*;
public class Suminarray {
	static boolean findSumOfTwo(int[] nums, int val) {
		// Initializing a hash set
		Set<Integer> foundValues = new HashSet<Integer>();

		// Traversing the nums list for each element 'ele'
		for (int ele : nums) {
			// If (val - ele) is present in the hash set, there is
			// at least one value among those already traversed that,
			// added to ele, equals the target value
			if (foundValues.contains(val - ele)) {
				return true;
			}

			// In case the current element does not pair up with one of those
			// already scanned, we add it to the hash set
			foundValues.add(ele);
		}

		// Return False if no sum is found
		return false;
	}

	public static void main(String[] args) {
		int[] v = new int[] {5, 7, 1, 2, 8, 4, 3};
		int[] test = new int[] {3, 20, 1, 2, 7};

		for (int i = 0; i < test.length; i++) {
			boolean output = findSumOfTwo(v, test[i]);
			System.out.println((i + 1) + ". findSumOfTwo(" + Arrays.toString(v) + ", " + test[i] + ") = " + String.valueOf(output));
			System.out.println(
					"----------------------------------------------------------------------------------------------------\n");
		}
	}
}


