package leetcode;

public class T684RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		int[] parents = new int[edges.length + 1];
		for (int i = 0; i < parents.length; i++)
			parents[i] = i;

		for (int[] edge : edges) {
			int f = edge[0];
			int t = edge[1];
			int pf = find(parents, f);
			int pt = find(parents, t);

			if (pf == pt)
				return edge;

			parents[pf] = pt;
		}

		return new int[] { 0, 0 };
	}

	private int find(int[] parents, int f) {
		if (f != parents[f])
			parents[f] = find(parents, parents[f]);
		return parents[f];
	}
}
