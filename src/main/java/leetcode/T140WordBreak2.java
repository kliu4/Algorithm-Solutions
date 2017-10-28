package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T140WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		// first to check if there is answer
		if (!hasAnswer(s, wordDict))
			return new ArrayList<String>();
		List<List<String>> dp = new ArrayList<>();

		dp.add(new ArrayList<String>());
		dp.get(0).add("");

		for (int i = 1; i <= s.length(); i++) {
			String subStr = s.substring(0, i);
			List<String> subList = new ArrayList<String>();
			for (String word : wordDict) {
				if (subStr.endsWith(word)) {
					List<String> part1List = dp.get(i - word.length());
					for (String part1 : part1List)
						subList.add(part1.equals("") ? word : part1 + " " + word);
				}
			}
			dp.add(subList);
		}
		return dp.get(s.length());
	}

	private boolean hasAnswer(String s, List<String> wordDict) {
		boolean[] sb = new boolean[s.length() + 1];
		sb[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			String subString = s.substring(0, i);
			for (String word : wordDict) {
				if (subString.endsWith(word) && sb[i - word.length()])
					sb[i] = true;
			}
		}
		return sb[s.length()];
	}

	public static void main(String[] args) {
		new T140WordBreak2().wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				Arrays.asList(new String[] { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
						"aaaaaaaaa", "aaaaaaaaaa" }));
	}
}
