package ed16;
import java.util.*;
class Solution {
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;

        // Return 1 if it is not present in the array
        int contains = 0;
        for (int i = 0; i < length; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        // Replacing negative numbers, zeros and elements
        // greater than the length of the array by 1.
        for (int i = 0; i < length; i++)
            if ((nums[i] <= 0) || (nums[i] > length))
                nums[i] = 1;

        // Use index as a hash key and number sign as a presence indicator.
        // For example, if nums[3] is negative that means that number `3`
        // is present in the array. 
        // If nums[4] is positive - number 4 is missing.
        for (int i = 0; i < length; i++) {
            int a = Math.abs(nums[i]);
            
            // When you meet number a in the array, change the sign of a-th element.
            // In order to avoid changing the sign of the element to positive on
            // encountering the duplicates we will take the absolute of the value.

            if (a == length)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // Now the index of the first positive number 
        // is equal to first missing positive.
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0)
                return i;
        }

         // If this value is postive, it means that 
        // length is missing from the array
        if (nums[0] > 0)
            return length;

        return length + 1;
    }

    public static void main(String[] args) {
        // Driver code
        int [] nums = {5, 8, 2, 7, 1, 6, 3};
        System.out.print("1. The smallest missing positive integer in " + PrintArray.print(nums) + " is: ");
        System.out.println(firstMissingPositive(nums));
        System.out.println("---------------------------------------------------------------------------------------------------\n");
       
        int [] nums2 = {0, 5, 1, 3, 2, 4};
        System.out.print("2. The smallest missing positive integer in " + PrintArray.print(nums2) + " is: ");
        System.out.println(firstMissingPositive(nums2));
        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }
}