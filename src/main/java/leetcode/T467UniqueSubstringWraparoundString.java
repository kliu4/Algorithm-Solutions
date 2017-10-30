package leetcode;

public class T467UniqueSubstringWraparoundString {
    private boolean isNext(char a, char b){
        return b > 'a' ? a == b - 1 : a == 'z';
    }
    
    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0)
            return 0;
        
        char[] chars = p.toCharArray();
        int[] dp = new int[chars.length];
        
        
        int prev = 1;
        
        int total = 1;
        
        
        for(int i = 1; i < chars.length; i++){
            char a = chars[i - 1];
            char b = chars[i];
            
            int cur = 1;
            if(isNext(a, b))
                cur += prev;
            
            total += cur;  
            prev = cur;
        }
        return total;
    }
}
