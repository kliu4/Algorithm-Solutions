package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class T179LargestNumber {
	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			strs[i] = "" + nums[i];
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String r1 = str1 + str2;
				String r2 = str2 + str1;
				return r1.compareTo(r2);
			}
		});
		String result = "";
		for (String str : strs)
			result = str + result;
		int i = 0;
		while (i < result.length()) {
			if (result.charAt(i) == '0')
				i++;
			else
				break;
		}
		result = result.substring(i, result.length());
		return result.equals("") ? "0" : result;
	}
	
	public static void main(String[] args) {
		System.out.println("a".compareTo("b"));
	}
}
