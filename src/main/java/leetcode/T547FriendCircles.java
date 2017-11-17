package leetcode;

public class T547FriendCircles {
	public void dfs(int[][] M, int i, int[] visited) {
		if (visited[i] == 1)
			return;
		visited[i] = 1;
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && visited[j] == 0) {
				dfs(M, j, visited);
			}
		}
	}

	public int findCircleNum(int[][] M) {
		if (M.length == 0 || M[0].length == 0)
			return 0;

		int count = 0;
		int[] visited = new int[M.length];
		for (int i = 0; i < M.length; i++) {
			if (visited[i] == 1)
				continue;
			dfs(M, i, visited);
			count++;
		}
		return count;
	}
}
