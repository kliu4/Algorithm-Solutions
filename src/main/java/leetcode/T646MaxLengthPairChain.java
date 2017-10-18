package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class T646MaxLengthPairChain {
	public int findLongestChain(int[][] pairs) {
		if(pairs.length == 0)
			return 0;
		
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] pair1, int[] pair2) {
				return pair1[0] - pair2[0] == 0 ? pair1[1] - pair2[1] : pair1[0] - pair2[0];
			}
		});
		
		int length = 1;
		int[] maxPair = pairs[0];
		
		for(int i = 1; i < pairs.length; i++) {
			int[] curPair = pairs[i];
			if(curPair[0] != maxPair[0]) {
				if(curPair[0]  > maxPair[1]) {
					length++;
					maxPair = curPair;
				}else if(curPair[1] < maxPair[1])
					maxPair = curPair;
			}
		}
		
		return length;
	}
	
	public static void main(String[] args) {
		System.out.println(new T646MaxLengthPairChain().findLongestChain(new int[][] {{1,2}, {2,3}, {3,4}}));
	}
}
