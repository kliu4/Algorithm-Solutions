package leetcode;

public class T670MaxSwap {
	public int maximumSwap(int num) {
        String str = Integer.toString(num);
        char[] chars = str.toCharArray();
        maxSwap(chars, 0);
        StringBuilder sb = new StringBuilder();
        for(char c:chars)
            sb.append(c);
        return Integer.parseInt(sb.toString());
    }
    
    private void maxSwap(char[] chars, int i){
        if(i >= chars.length - 1)
            return;
        
        char max = '0';
        int maxIndex = chars.length - 1;
        for(int j = chars.length - 1; j > i; j--){
            if(chars[j] > max){
                max = chars[j];
                maxIndex = j;
            }
        }
        
        if(max > chars[i]){
            swap(chars, i, maxIndex);
            return;
        }else{
            maxSwap(chars, i + 1);
        }
        
    }
    
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
