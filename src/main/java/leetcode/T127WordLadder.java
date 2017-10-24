package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class T127WordLadder {
	private List<String> getNext(String word, Set<String> wordSet) {
		char[] chars = word.toCharArray();
		List<String> nexts = new ArrayList<String>();

		for (int i = 0; i < chars.length; i++) {
			char tempC = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == tempC)
					continue;
				chars[i] = c;
				String tempS = new String(chars);
				if (wordSet.contains(tempS))
					nexts.add(tempS);
			}
			chars[i] = tempC;
		}
		return nexts;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> visited = new HashSet<String>();
		Set<String> wordSet = new HashSet<String>(wordList);

		int depth = 1;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		visited.add(beginWord);

		while (!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				List<String> nexts = getNext(queue.poll(), wordSet);
				for (String next : nexts) {
					if (next.equals(endWord))
						return depth;
					if (!visited.contains(next))
						queue.add(next);
					visited.add(next);
				}
			}
		}

		return 0;
	}
}
