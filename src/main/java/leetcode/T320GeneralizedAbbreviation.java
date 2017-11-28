package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T320GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<String>();
		dfs(word.toCharArray(), 0, "", 0, result);
		return result;
	}

	private void dfs(char[] chars, int index, String str, int counts, List<String> result) {
		if (index == chars.length) {
            if(counts > 0)
                str += counts;
			result.add(str);
			return;
		}
		dfs(chars, index + 1, str, counts + 1, result);
		String newStr = str + (counts == 0 ? "" : "" + counts) + chars[index];
		dfs(chars, index + 1, newStr, 0, result);
	}
}
