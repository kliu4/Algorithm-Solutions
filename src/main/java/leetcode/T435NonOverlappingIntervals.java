package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class T435NonOverlappingIntervals {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end == 0 ? i1.start - i2.start : i1.end - i2.end;
			}
		});

		int num = 0;
		Interval prev = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (intersect(prev, intervals[i]))
				num++;
			else
				prev = intervals[i];
		}
		return num;
	}

	// i1.end <= i2.end
	private boolean intersect(Interval i1, Interval i2) {
		return i1.end > i2.start;
	}
}
