package leetcode;

public class T621TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int[] counts = new int[26];
		for (char c : tasks)
			counts[c - 'A']++;

		int max = 0;
		for (int count : counts)
			max = Math.max(max, count);

		int firstPart = (n + 1) * (max - 1);
		int secondPart = 0;
		for (int count : counts)
			if (count == max)
				secondPart++;

		return firstPart + secondPart > tasks.length ? firstPart + secondPart : tasks.length;
	}
}
