package ed14;
import java.util.*;
public class arrangelargestnumber {
	 private static class LargerNumberComparator implements Comparator<String> {
	        // Takes two strings and returns 0, 1, or -1 
	        // by comparing the strings formed by the 
	        // concatenation of these strings, i.e., whether
	        // they are greater, lesser or equal to each other.
	        public int compare(String a, String b) {
	            String order1 = a + b;
	            String order2 = b + a;
	           return order2.compareTo(order1);
	        }
	    }

	    public static String largestNumber(int[] nums) {
	        // Converting the integers into strings a
	        String[] numStr = new String[nums.length];
	        for (int i = 0; i < nums.length; i++) {
	            numStr[i] = String.valueOf(nums[i]);
	        }// Sorting our strings according to the value returned by our custom operator.
	        Arrays.sort(numStr, new LargerNumberComparator());

	        // We return 0 if we get strings like:
	        // "00", "000".
	        if (numStr[0].equals("0")) {
	            return "0";
	        }

	        // Otherwise we build and return the new string formed 
	        // from the values obtained by our sorted array.
	        String largestNumberStr = new String();
	        for (String numAsStr : numStr) {
	            largestNumberStr += numAsStr;
	        }

	        return largestNumberStr;
	    }

	    public static void main(String[] args) {
	        // Driver code
	    	 int [] nums = {5, 8, 2, 7, 1, 6, 3};
	         System.out.println("1. The largest possible number obtained by arranging " + Arrays.toString(nums) + " is: \"" + largestNumber(nums) + "\"");
	         System.out.println("---------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator"));

	         int [] nums2 = {0, 5, 1, 3, 2, 4};
	         System.out.println("2. The largest possible number obtained by arranging " + Arrays.toString(nums2) + " is: \"" + largestNumber(nums2) + "\"");
	         System.out.println("---------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator"));

	         int [] nums3 = {71, 5, 21, 52};
	         System.out.println("3. The largest possible number obtained by arranging " + Arrays.toString(nums3) + " is: \"" + largestNumber(nums3) + "\"");
	         System.out.println("---------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator"));

	         int [] nums4 = {0, 0, 0};
	         System.out.println("4. The largest possible number obtained by arranging " + Arrays.toString(nums4) + " is: \"" + largestNumber(nums4) + "\"");
	         System.out.println("---------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator"));

	         int [] nums5 = {1};
	         System.out.println("5. The largest possible number obtained by arranging " + Arrays.toString(nums5) + " is: \"" + largestNumber(nums5) + "\"");
	         System.out.println("---------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator"));
	     }
}
