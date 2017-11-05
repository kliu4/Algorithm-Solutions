package leetcode;

public class T546RemoveBoxes {
	public int removeBoxes(int[] boxes) {
		int[][][] mem = new int[boxes.length][boxes.length][boxes.length];
		return removeBoxes(boxes, mem, 0, boxes.length - 1, 1);
	}

	private int removeBoxes(int[] boxes, int[][][] mem, int l, int r, int k) {
		if (l > r)
			return 0;

		if (mem[l][r][k] != 0)
			return mem[l][r][k];

		while (r > l && boxes[r] == boxes[r - 1]) {
			k++;
			r--;
		}

		mem[l][r][k] = removeBoxes(boxes, mem, l, r - 1, 1) + k * k;

		for (int i = l; i < r; i++)
			if (boxes[i] == boxes[r])
				mem[l][r][k] = Math.max(mem[l][r][k],
						removeBoxes(boxes, mem, l, i, k + 1) + removeBoxes(boxes, mem, i + 1, r - 1, 1));

		return mem[l][r][k];
	}

	public static void main(String[] args) {
		System.out.println(new T546RemoveBoxes().removeBoxes(new int[] { 1, 3, 2, 2, 2, 3, 4, 3, 1 }));
	}
}
