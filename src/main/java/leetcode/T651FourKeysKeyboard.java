package leetcode;

public class T651FourKeysKeyboard {
	public int maxA(int N) {
        if(N <= 4)
            return N;
        int[] counts = new int[N + 1];
        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 3;
        counts[4] = 4;
        
        for(int i = 4; i < N + 1; i++){
            counts[i] = counts[i - 1] + 1;
            for(int j = 3; i - j >= 1; j++){
                counts[i] = Math.max(counts[i], counts[i - j] * (j - 1));
            }
        }
        return counts[N];
    }
}
