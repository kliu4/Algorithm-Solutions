package leetcode;

public class T467UniqueSubstringWraparoundString {
	public int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0)
			return 0;

		char[] chars = p.toCharArray();
		char[] prevs = "zabcdefghijklmnopqrstuvwxy".toCharArray();
		int[] used = new int['z' - 'a' + 1];
		used[chars[0] - 'a'] = 1;
		int prev = 1;
		for (int i = 1; i < chars.length; i++) {
			int cur = 1;
			if (chars[i - 1] == prevs[chars[i] - 'a'])
				cur = prev + 1;
			used[chars[i] - 'a'] = Math.max(used[chars[i] - 'a'], cur);
			prev = cur;
		}

		int total = 0;
		for (int i : used)
			total += i;

		return total;
	}
}
