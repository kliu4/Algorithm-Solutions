package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T216CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		dfs(k, n, 1, new ArrayList<Integer>(), list);
		return list;
	}

	private void dfs(int k, int n, int start, List<Integer> subList, List<List<Integer>> list) {
		if (k == 0) {
			if (n == 0)
				list.add(new ArrayList<>(subList));
			return;
		}

		for (int i = start; i <= 9; i++) {
			if (i > n)
				return;
			subList.add(i);
			dfs(k - 1, n - i, i + 1, subList, list);
			subList.remove(subList.size() - 1);
		}
	}
}
