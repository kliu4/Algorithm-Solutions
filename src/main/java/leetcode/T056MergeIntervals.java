package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Interval;

public class T056MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		for (Interval interval : intervals) {
			if (result.isEmpty() || result.get(result.size() - 1).end < interval.start)
				result.add(interval);
			else
				result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, interval.end);
		}

		return result;
	}
}
