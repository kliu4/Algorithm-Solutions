package leetcode;

public class T668KthSmallestNumberInMultiplicationTable {
	public int findKthNumber(int m, int n, int k) {
		int lo = 1, hi = m * n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (!enough(mid, m, n, k))
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

	public boolean enough(int x, int m, int n, int k) {
		int count = 0;
		for (int i = 1; i <= m; i++)
			count += Math.min(x / i, n);
		return count >= k;
	}
}
