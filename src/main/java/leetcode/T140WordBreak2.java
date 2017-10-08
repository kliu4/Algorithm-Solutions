package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T140WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> results = new ArrayList<String>();
		Set<String> set = new HashSet<String>(wordDict);
		helper(s, set, 0, results, "");
		return results;
	}

	private void helper(String s, Set<String> set, int start, List<String> results, String solution) {
		if (start >= s.length()) {
			results.add(solution.trim());
			return;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String subString = s.substring(start, i);
			if (!set.contains(subString))
				continue;
			solution += " " + subString;
			helper(s, set, i, results, solution);
			solution = solution.substring(0, solution.length() - 1 - subString.length());
		}
	}
}
