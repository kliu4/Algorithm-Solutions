package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class T126WordLadder2 {
	private Set<String> getNeighbors(String word, Set<String> wordSet) {
		Set<String> set = new HashSet<>();
		char[] chars = word.toCharArray();
		for (int i = 0; i < word.length(); i++)
			for (char c = 'a'; c <= 'z'; c++) {
				char oldC = chars[i];
				if (c != oldC) {
					chars[i] = c;
					String str = new String(chars);
					if (wordSet.contains(str))
						set.add(str);
					chars[i] = oldC;
				}
			}
		return set;
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>();
		for (String str : wordList)
			wordSet.add(str);

		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		Map<String, Set<String>> neighborMap = new HashMap<>();

		Map<String, Integer> distanceMap = new HashMap<>();

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		visited.add(beginWord);
		distanceMap.put(beginWord, 1);
		boolean isFound = false;

		while (!queue.isEmpty() && !isFound) {
			String parent = queue.poll();
			Set<String> neighbors = getNeighbors(parent, wordSet);
			neighborMap.put(parent, neighbors);
			int parentDistance = distanceMap.get(parent);
			for (String str : neighbors) {
				if (visited.contains(str))
					continue;
				visited.add(str);
				distanceMap.put(str, parentDistance + 1);
				if (str.equals(endWord)) {
					isFound = true;
					break;
				}
				queue.offer(str);
			}
		}

		List<List<String>> result = new ArrayList<>();

		if (!isFound)
			return result;

		List<String> subList = new ArrayList<>();
		subList.add(beginWord);
		helper(endWord, wordSet, result, subList, neighborMap, distanceMap, visited, 2, distanceMap.get(endWord));
		return result;
	}

	private void helper(String endWord, Set<String> wordSet, List<List<String>> result, List<String> subList,
			Map<String, Set<String>> neighborMap, Map<String, Integer> distanceMap, Set<String> visited, int distance,
			int endWordDistance) {
		if (distance > endWordDistance)
			return;

		String parent = subList.get(subList.size() - 1);
		if (!visited.contains(parent))
			return;

		Set<String> neighbors = neighborMap.containsKey(parent) ? neighborMap.get(parent)
				: getNeighbors(parent, wordSet);
		for (String neighbor : neighbors) {
			if (!visited.contains(neighbor) || distanceMap.get(neighbor) != distance)
				continue;
			subList.add(neighbor);
			if (neighbor.equals(endWord))
				result.add(new ArrayList<>(subList));
			helper(endWord, wordSet, result, subList, neighborMap, distanceMap, visited, distance + 1, endWordDistance);
			subList.remove(subList.size() - 1);
		}

	}

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>(
				Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));

		new T126WordLadder2().findLadders("hit", "cog", wordList);

	}
}
