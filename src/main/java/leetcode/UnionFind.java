package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
	Map<Integer, Integer> map = new HashMap<>(); 
	
	public UnionFind(int n) {
		for (int i = 0; i <= n; i++) {
			map.put(i, i);
		}
	}
	
	private int find(int x) {
		if (x == map.get(x)) {
			return x;
		}
		
		map.put(x, find(map.get(x)));
		return map.get(x);
	}
	
	public void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			map.put(rootA, rootB);
		}
	}
}
