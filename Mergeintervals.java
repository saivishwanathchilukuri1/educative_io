package ed8;
import java.util.*;

//Creating a tuple class as java does not support returning
//multiple arguments
class Pair {
	public int first;
	public int second;

	public Pair(int x, int y) {
		this.first = x;
		this.second = y;
	}
}
class Mergeintervals {
	static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
		// If the list is empty
		if (v == null || v.size() == 0) {
			return null;
		}

		ArrayList<Pair> result = new ArrayList<Pair>();

		// Adding pair in the result list
		result.add(new Pair(v.get(0).first, v.get(0).second));

		for (int i = 1; i < v.size(); i++) {
			// Getting the recent added pair in the result list
			Pair recentAddedPair = result.get(result.size() - 1);

			// Getting and initializing input pair
			int currStart = v.get(i).first;
			int currEnd = v.get(i).second;

			// Getting and initializing recently added pair from result list
			int prevEnd = recentAddedPair.second;

			// Overlapping condition
			if (prevEnd >= currStart) {
				recentAddedPair.second = Math.max(currEnd, prevEnd);
			}

			// No overlapping
			else {
				result.add(new Pair(currStart, currEnd));
			}
		}

		return result;
	}

	// Printing list of interval pairs
	public static void printPairList(ArrayList<Pair> lst) {
		String resultStr = "";
		for (int i = 0; i < lst.size(); i++) {
			Pair p = lst.get(i);
			resultStr += "(" + p.first + "," + p.second + ")";
			if (i != lst.size() - 1)
				resultStr += ",";
		}
		System.out.println(". Intervals to merge:\t[" + resultStr + "]");
	}

	public static void main(String[] args) {
		Pair[] v1 = {new Pair(1, 5), new Pair(3, 7), new Pair(4, 6)};
		Pair[] v2 = {new Pair(1, 5), new Pair(4, 6), new Pair(6, 8), new Pair(11, 15)};
		Pair[] v3 = {new Pair(3, 7), new Pair(6, 8), new Pair(10, 12), new Pair(11, 15)};
		Pair[] v4 = {new Pair(1, 5)};
		Pair[][] vList = {v1, v2, v3, v4};

		for (int i = 0; i < vList.length; i++) {
			ArrayList<Pair> v = new ArrayList<Pair>(Arrays.asList(vList[i]));
			System.out.print(i + 1);
			printPairList(v);
			ArrayList<Pair> result = mergeIntervals(v);
			String result_str = "";
			for (int j = 0; j < result.size(); j++) {
				result_str += "[" + result.get(j).first + ", " + result.get(j).second + "] ";
			}
			System.out.println("   Merged intervals:\t" + result_str);
			System.out.println(
					"----------------------------------------------------------------------------------------------------\n");
		}
	}
}
