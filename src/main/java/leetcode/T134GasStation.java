package leetcode;

public class T134GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {   
        for(int i = 0; i < gas.length; i++){
            int sum = 0;
            boolean canDo = true;
            for(int j = 0; j < gas.length; j++){
                int index = (i + j ) % gas.length;
                sum += gas[index] - cost[index];
                if(sum < 0){
                    canDo = false;
                    i = i + j;
                    break;
                }
            }
            
            if(canDo)
                return i;
        }
        return -1;
    }
}
