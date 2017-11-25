package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T681NextClosestTime {
	public static final int day = 60 * 24;

	public String nextClosestTime(String time) {
		Set<Integer> set = new HashSet<>();
		String[] parts = time.split(":");
		for (String part : parts) {
			set.add(Integer.parseInt(part.substring(0, 1)));
			set.add(Integer.parseInt(part.substring(1)));
		}
		int original = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);

		List<Integer> digits = new ArrayList<Integer>(set);

		int min = Integer.MAX_VALUE;
		String minStr = "";
		for (int a = 0; a < digits.size(); a++)
			for (int b = 0; b < digits.size(); b++) {
				int hours = digits.get(a) * 10 + digits.get(b);
				if (hours >= 24)
					continue;
				for (int c = 0; c < digits.size(); c++)
					for (int d = 0; d < digits.size(); d++) {
						int mins = digits.get(c) * 10 + digits.get(d);
						if (mins >= 60)
							continue;

						int total = hours * 60 + mins;

						int diff = (total - original + day) % day;

						if (diff == 0)
							diff = day;

						if (min > diff) {
							min = diff;
							minStr = "" + digits.get(a) + digits.get(b) + ":" + digits.get(c) + digits.get(d);
						}
					}
			}

		return minStr;
	}
}
