package leetcode;

public class T650TwoKeysKeyboard {
    public int minSteps(int n) {
        int[] operations = new int[n + 1];
        
        for(int i = 2; i < n + 1; i ++){
            int min = i;
            for(int j = 2; j <= i / 2; j++)
                if(i % j == 0)
                    min = Math.min(min, operations[j] + i / j);
            operations[i] = min;
        }
        return operations[n];
    }
    
    public static void main(String[] args) {
		System.out.println(new T650TwoKeysKeyboard().minSteps(6));
	}
}
