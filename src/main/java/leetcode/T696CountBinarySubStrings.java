package leetcode;

public class T696CountBinarySubStrings {
	public int countBinarySubstrings(String s) {
		int count = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (helper(chars, i)) {
				count++;
			}
		}
		return count;
	}

	private boolean helper(char[] chars, int i) {
		int cZeros = 0;
		int cOnes = 0;
		char pre = chars[i];
		while (i < chars.length) {
			if (pre != chars[i] && cZeros != 0 && cOnes != 0)
				break;
			if (chars[i] == '0')
				cZeros++;
			if (chars[i] == '1')
				cOnes++;
			if (cZeros >= 1 && cZeros == cOnes)
				return true;
			pre = chars[i];
			i++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new T696CountBinarySubStrings().countBinarySubstrings("10101"));
	}
}
