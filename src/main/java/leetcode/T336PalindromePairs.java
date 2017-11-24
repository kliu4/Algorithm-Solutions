package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T336PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j <= word.length(); j++) {
				String l = word.substring(0, j);
				String r = word.substring(j, word.length());
				if (isPalindrome(l)) {
					// reverse part
					String rp = new StringBuilder(r).reverse().toString();
					if (map.containsKey(rp) && map.get(rp) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(rp));
						list.add(i);
						result.add(list);
					}
				}
				if (isPalindrome(r)) {
					// reverse part
					String rp = new StringBuilder(l).reverse().toString();
					if (map.containsKey(rp) && map.get(rp) != i && j != word.length()) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(rp));
						result.add(list);
					}
				}
			}
		}

		return result;
	}

	private boolean isPalindrome(String word) {
		for (int l = 0, r = word.length() - 1; l <= r; l++, r--) {
			if (word.charAt(l) != word.charAt(r))
				return false;
		}

		return true;
	}
}
