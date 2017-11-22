package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T658FindKClosetElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		if (arr.length == 0)
			return res;

		int index = Arrays.binarySearch(arr, x);
		if (index < 0)
			index = -index - 1;

		int left = index - 1;
		int right = index;

		int count = 0;
		while (count < k) {
			if (left < 0) {
				res.add(arr[right]);
				right++;
			} else if (right > arr.length - 1) {
				res.add(0, arr[left]);
				left--;
			} else {
				int leftAbs = Math.abs(x - arr[left]);
				int rightAbs = Math.abs(arr[right] - x);
				if (leftAbs <= rightAbs) {
					res.add(0, arr[left]);
					left--;
				} else {
					res.add(arr[right]);
					right++;
				}
			}
			count++;
		}

		return res;
	}

	public static void main(String[] args) {
		for (int i : new T658FindKClosetElements().findClosestElements(new int[] { 0, 0, 1, 2, 3, 3, 4, 7, 7, 8 }, 3,
				5))
			System.out.println(i);
	}
}
