package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T682BaseballGame {
	public int calPoints(String[] ops) {
		List<Integer> list = new ArrayList<Integer>();
		for (String str : ops) {
			if (str.equals("+"))
				list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
			else if (str.equals("D"))
				list.add(list.get(list.size() - 1) * 2);
			else if (str.equals("C"))
				list.remove(list.size() - 1);
			else
				list.add(Integer.parseInt(str));
		}

		// get the sum
		int sum = 0;
		for (int i : list)
			sum += i;

		return sum;
	}
}
