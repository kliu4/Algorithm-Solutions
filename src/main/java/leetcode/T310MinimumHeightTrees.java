package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T310MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1)
			return Collections.singletonList(0);
		List<Set<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(new HashSet<>());

		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++)
			if (list.get(i).size() == 1)
				leaves.add(i);

		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				int j = list.get(i).iterator().next();
				list.get(j).remove(i);
				list.get(i).remove(j);
				if (list.get(j).size() == 1)
					newLeaves.add(j);
			}
			leaves = newLeaves;
		}

		return leaves;
	}
}
