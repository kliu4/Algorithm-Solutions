package leetcode;

import java.util.Arrays;

public class T685RedundantConnection2 {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int[] parent = new int[edges.length + 1];
		int[] rank = new int[edges.length + 1];
		Arrays.fill(rank, 1);

		// two candidates
		int[] candidate1 = new int[2];
		int[] candidate2 = new int[2];

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			if (parent[edge[1]] != 0) {
				candidate1 = new int[] { parent[edge[1]], edge[1] };
				candidate2 = new int[] { edge[0], edge[1] };
				edges[i] = new int[] { 0, 0 };
				break;
			}
			parent[edge[1]] = edge[0];
		}

		for (int i = 1; i < edges.length + 1; i++)
			parent[i] = i;

		for (int[] edge : edges) {
			int p = edge[0];
			int q = edge[1];

			if (p == 0 || q == 0)
				continue;

			int parentP = find(parent, p);
			int parentQ = find(parent, q);

			if (parentP == parentQ)
				return candidate1[0] == 0 ? edge : candidate1;

			if (rank[parentP] < rank[parentQ]) {
				parent[parentP] = parentQ;
				rank[parentQ] += rank[parentP];
			} else {
				parent[parentQ] = parentP;
				rank[parentP] += rank[parentQ];
			}
		}

		return candidate2;
	}

	private int find(int[] parent, int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new T685RedundantConnection2()
				.findRedundantDirectedConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } })));
	}
}
