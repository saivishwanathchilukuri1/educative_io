package educative1;


	// Importing required functions
	import java.util.*;

	class Arrayrotation {
		static void reverseArray(List<Integer> nums, int start, int end) {
			while (start < end) {
				int temp = nums.get(start);
				nums.set(start, nums.get(end));
				nums.set(end, temp);
				++start;
				--end;
			}
		}

		static void rotateArray(List<Integer> nums, int n) {

			int len = nums.size();
			// Normalizing the 'n' rotations
			n = n % len;
			if (n < 0) {
				n = n + len;
			}

			// Let's partition the numsay based on rotations 'n'
			reverseArray(nums, 0, len - 1);
			reverseArray(nums, 0, n - 1);
			reverseArray(nums, n, len - 1);
		}

		public static void main(String[] args) {
			List<Integer> nums = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
			System.out.println("Array Before Rotation\n" + nums);
			rotateArray(nums, 2);
			System.out.println("Array After 2 Rotations\n" + nums);
		}
	}

