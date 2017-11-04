package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T691StickersToSpellWord {
Map<String, Integer> mem = new HashMap<>();
	
	public int minStickers(String[] stickers, String target) {
		if (target == null || target.equals(""))
			return 0;
		int len = 'z' - 'a' + 1;
		int l = stickers.length;
		int[][] ms = new int[l][len];
		
		int[] ts = new int[len];
		for(char c:target.toCharArray())
			ts[c - 'a']++;
		
		int[] tsCopy = ts.clone();
		for (int i = 0; i < stickers.length; i++) {
			for (char c : stickers[i].toCharArray()) {
				ms[i][c - 'a']++;
				ts[c - 'a'] = 0;
			}
            
            //quick check if answer is 1
			boolean ans1 = true;
			for(int j = 0; j < len; j++)
				if(ms[i][j] < tsCopy[j]) {
					ans1 = false;
					break;
				}
			if(ans1)
				return 1;
		}
		
		//quick check if it has answer
		for(int i = 0; i < ts.length; i++)
			if(ts[i] != 0)
				return -1;
		
		return helper(ms, target, len);
	}

	private String getNewTarget(int[] ts) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ts.length; i++)
			for(int j = 0; j < ts[i]; j++)
				sb.append((char)(i + 'a'));
		return sb.toString();
	}

	private int helper(int[][] ms, String target, int len) {
		if (mem.containsKey(target))
			return mem.get(target);

		if (target.equals(""))
			return 0;

		int tempMin = Integer.MAX_VALUE;

		int[] ts = new int[len];
		for(char c:target.toCharArray())
			ts[c - 'a']++;
		
		for(int i = 0; i < ms.length; i++) {
			int[] tsCopy = ts.clone();
			for(int j = 0; j < len; j++)
				tsCopy[j] -= ms[i][j];
			String newTarget = getNewTarget(tsCopy);
			if(newTarget.length() == target.length())
				continue;
			tempMin = Math.min(tempMin, 1+ helper(ms, newTarget, len));
			if(tempMin == 1)
				break;
		}
		mem.put(target, tempMin);
		return tempMin;
	}
	
	public static void main(String[] args) {
		System.out.println(new T691StickersToSpellWord().minStickers(new String[] {"with","example","science"}, "thehat"));
	}
}
