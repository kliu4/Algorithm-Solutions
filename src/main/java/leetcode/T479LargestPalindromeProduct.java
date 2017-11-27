package leetcode;

public class T479LargestPalindromeProduct {
	private static final int BASE = 1337;
	
	public int largestPalindrome(int n) {
		if(n == 1)
			return 9;
		if(n == 2)
			return 987;
		long max =  (long)Math.pow(10, n) * (long)Math.pow(10, n) - 1;
        String maxStr = "" + max;
        long left = Long.parseLong(maxStr.substring(0, n));
        long upper = (long) Math.pow(10, n) - 1;
        long lower = (long)Math.pow(10, n - 1) + 1;
        
        while(left > 0) {
        		long palindrome = createPalindrome(Long.toString(left));
        		for(long i = upper; i >= lower; i--) {
        			if(palindrome / i > upper || palindrome / i < lower)
        				break;
        			if(palindrome % i == 0)
        				return (int)(palindrome % BASE);
        		}
        	
        		left--;
        }
        
        return 0;
    }
	
	private long createPalindrome(String left) {
		String res = left;
		for(int i = left.length() - 1; i >= 0; i--) 
			res += left.charAt(i);
		return Long.parseLong(res);
	}
	
	public static void main(String[] args) {
		System.out.println(new T479LargestPalindromeProduct().largestPalindrome(4));
	}
}
