package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T464CanIWin {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
		if (sum < desiredTotal)
			return false;
		return canIWin(new int[maxChoosableInteger + 1], desiredTotal, new HashMap<String, Boolean>());
	}

	private boolean canIWin(int[] selected, int desiredTotal, Map<String, Boolean> mem) {
		String key = Arrays.toString(selected);
		if (mem.containsKey(key))
			return mem.get(key);

		for (int i = 1; i < selected.length; i++) {
			if (selected[i] != 0)
				continue;
			selected[i] = 1;
			if (i >= desiredTotal || !canIWin(selected, desiredTotal - i, mem)) {
				mem.put(key, true);
				selected[i] = 0;
				return true;
			}
			selected[i] = 0;
		}
		mem.put(key, false);
		return false;
	}
}
