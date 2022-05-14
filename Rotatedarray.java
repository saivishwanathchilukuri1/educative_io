package ed2;
import java.util.*;
public class Rotatedarray {

	static int binarySearchRotated(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (start > end)
            return -1;

        while (start <= end) {
            // Finding the mid using floor division
            int mid = start + (end - start) / 2;

            // Target value is present at the middle of the array
            if (nums[mid] == target)
                return mid;

            // start to mid is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            // mid to end is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] targetList = {3, 6, 3, 6};
        int[][] numsList = {{6, 7, 1, 2, 3, 4, 5}, {6, 7, 1, 2, 3, 4, 5}, {4, 5, 6, 1, 2, 3},
                {4, 5, 6, 1, 2, 3}};

        for (int i = 0; i < targetList.length; i++) {
            System.out.println((i + 1) + ". Rotated array: " + Arrays.toString(numsList[i]));
            System.out.println("   target " + targetList[i] + " found at index "+ binarySearchRotated(numsList[i], targetList[i]));
            System.out.println( "----------------------------------------------------------------------------------------------------\n");
        }
    }
}

