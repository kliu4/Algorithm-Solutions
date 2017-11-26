package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T616AddBoldTagInString {
	public String addBoldTag(String s, String[] dict) {
		if (s == null || s.equals("") || dict.length == 0)
			return s;

		List<int[]> list = new ArrayList<>();
		for (String word : dict) {
			int i = s.indexOf(word);
			while (i != -1) {
				list.add(new int[] { i, i + word.length() });
				i = s.indexOf(word, i + 1);
			}
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] interval1, int[] interval2) {
				return interval1[0] - interval2[0];
			}
		});

		List<int[]> mergedList = new ArrayList<>();
		if (!list.isEmpty()) {
			int start = list.get(0)[0];
			int end = list.get(0)[1];

			for (int[] interval : list) {
				if (interval[0] <= end) {
					end = Math.max(end, interval[1]);
				} else {
					mergedList.add(new int[] { start, end });
					start = interval[0];
					end = interval[1];
				}
			}
			mergedList.add(new int[] { start, end });
		}

		String result = "";
		int index = 0;
		for (int[] interval : mergedList) {
			result += s.substring(index, interval[0]);
			result += "<b>" + s.substring(interval[0], interval[1]) + "</b>";
			index = interval[1];
		}

		result += s.substring(index, s.length());
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new T616AddBoldTagInString().addBoldTag("aaabbcc", new String[] { "aaa", "aab", "bc" }));
	}
}
