package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T091DecodeWays {
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numDecodings(String s) {
        if(s == null || s.equals(""))
            return 0;
        
        return numDecodings(s.toCharArray(), 0);
    }
    
    private int numDecodings(char[] chars, int l){
        if(l >= chars.length)
            return 1;
        if(l == chars.length - 1)
            return chars[l] == '0' ? 0 : 1;
        
        if(map.containsKey(l))
            return map.get(l);
        
        int num1 = chars[l] - '0';
        int num2 = num1 * 10 + (chars[l + 1] - '0');
        
        int case1 = num1 == 0 ? 0 : numDecodings(chars, l + 1);
        int case2 = num2 > 26 || num2 < 10 ? 0 : numDecodings(chars, l + 2);
        
        map.put(l, case1 + case2);
        return case1 + case2;
    }
}
