package leetcode;

public class T481MagicalString {
	public int magicalString(int n) {
		if(n == 0)
			return 0;
		if(n <= 3)
			return 1;
		
		int[] a = new int[n + 1];
		a[1] = 1; 
		a[2] = 2;
		a[3] = 2;
		
		int result = 1;
		int num = 1;
		int fastIndex = 4;
		int slowIndex = 3;
		
		while(fastIndex <= n) {
			for(int i = 0; i < a[slowIndex] && fastIndex <= n; i++) {
				a[fastIndex] = num;
				if(num == 1)
					result++;
				fastIndex++;
			}
			num = num == 2 ? 1 : 2;
			slowIndex++;
		}
		
		return result;
	}
}
