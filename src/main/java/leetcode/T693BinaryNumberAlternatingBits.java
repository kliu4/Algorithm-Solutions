package leetcode;

public class T693BinaryNumberAlternatingBits {
	public boolean hasAlternatingBits(int n) {
		int oldBit = n % 2;
		n = n / 2;
		while(n != 0) {
			int newBit = n % 2;
			if((newBit ^ oldBit) != 1)
				return false;
			n = n / 2;
			oldBit = newBit;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new T693BinaryNumberAlternatingBits().hasAlternatingBits(7));
	}
}
