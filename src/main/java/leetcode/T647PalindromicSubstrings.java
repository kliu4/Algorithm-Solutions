package leetcode;

public class T647PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            
            //c is center;
            for(int j = 0; i + j < chars.length && i - j >= 0; j++){
                if(chars[i + j] != chars[i - j])
                    break;
                count++;
            }
            
            //c and the following  is center
            for(int j = 0; i + j + 1 < chars.length && i - j >=0; j++){
                if(chars[i - j] != chars[i + j + 1])
                    break;
                count++;
            }
        }
        return count;
    }
}
