package leetcode;

public class T443StringCompression {
	int newIndex = 0;

	public int compress(char[] chars) {
		 return  compress(chars, 0);
	}

	private int compress(char[] chars, int i) {
		if (i >= chars.length)
			return 0;

		char c = chars[i];
		int count = 1;
		int j = i + 1;
		for (; j < chars.length; j++) {
			if (chars[j] == c)
				count++;
			else
				break;
		}
		chars[newIndex++] = c;
		return 1 + getNumbers(chars, count, c) + compress(chars, j);
	}

	private int getNumbers(char[] chars, int i, char c) {
		if (i == 1) {
			return 0;
		}
		int count = 1;
		int m = i;
		while (m / 10 != 0) {
			count++;
			m = m / 10;
			chars[newIndex++] = (char) (m + '0');
		}
		chars[newIndex++] = (char) (i % 10 + '0');
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println((char)(2 + '0'));
		new T443StringCompression().compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'});
	}
}
