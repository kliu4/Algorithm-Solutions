package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T676ImplementMagicDic {

	Map<Integer, Set<String>> map;

	/** Initialize your data structure here. */
    public T676ImplementMagicDic() {
        map = new HashMap<Integer, Set<String>>();
    }

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String str : dict) {
			Set<String> set = map.getOrDefault(str.length(), new HashSet<String>());
			set.add(str);
			map.put(str.length(), set);
		}
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word after
	 * modifying exactly one character
	 */
	public boolean search(String word) {
		if (!map.containsKey(word.length()))
			return false;

		Set<String> set = map.get(word.length());
		for (String str : set) {
			if (canConvert(str, word))
				return true;
		}
		return false;
	}

	private boolean canConvert(String word1, String word2) {
		char[] chars1 = word1.toCharArray();
		char[] chars2 = word2.toCharArray();
		int diff = 0;
		for (int i = 0; i < chars1.length; i++) {
			if (chars1[i] != chars2[i])
				diff++;
			if (diff > 1)
				return false;
		}
		return diff == 1;
	}
}
