package leetcode;

public class T667BeautifulArrangement2 {
	public int[] constructArray(int n, int k) {
		int[] r = new int[n];
		for (int i = 0; i < n; i++)
			r[i] = i + 1;

		boolean isAdd = true;
		for (int j = 1; j < n && k >= 1; k--, j++) {
			r[j] = isAdd ? r[j - 1] + k : r[j - 1] - k;
			isAdd = !isAdd;
		}

		return r;
	}
}
