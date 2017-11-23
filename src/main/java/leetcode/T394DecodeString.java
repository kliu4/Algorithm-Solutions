package leetcode;

import java.util.Stack;

public class T394DecodeString {
    public String decodeString(String s) {
        return decodeString(s.toCharArray(), 0, s.length() - 1);
    }
    
    private String decodeString(char[] chars, int l, int r) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(int i = l; i <= r; i++){
            if('[' == chars[i]){
                int j = i + 1;
                int count = 1;
                while(j <= r && count != 0){
                    if(chars[j] == '[')
                        count++;
                    if(chars[j] == ']')
                        count--;
                    j++;
                }
                String inner = decodeString(chars, i + 1, j - 1);
                
                for(int a = 0; a < n; a++)
                    sb.append(inner);
                return sb.toString() + decodeString(chars, j, r);
            }
            if('a' <= chars[i] && chars[i] <= 'z')
                sb.append(chars[i]);
            if('0' <= chars[i] && chars[i] <= '9')
                n = n * 10 + chars[i] - '0';
        }
        return sb.toString();
    }
}
