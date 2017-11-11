package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class T491IncreasingSubsequences {
	List<List<List<Integer>>> list = new ArrayList<>();
    Map<Integer, Set<List<Integer>>> map = new HashMap<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        list.add(new ArrayList<>());
        for(int i = 1; i < nums.length; i++)
            dfs(nums, i);
        
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, Set<List<Integer>>> entry: map.entrySet())
            for(List<Integer> subList: entry.getValue())
                result.add(subList);
        
        return result;
    }
    
    private void dfs(int[] nums, int i){
        Set<List<Integer>> set = map.getOrDefault(nums[i], new HashSet<List<Integer>>());
        List<List<Integer>> curList = new ArrayList<>();
        
        for(int a = 0; a < i; a++){
            if(nums[a] <= nums[i]){
                for(List<Integer> subList : list.get(a)){
                    List<Integer> newSubList = new ArrayList<Integer>(subList);
                    newSubList.add(nums[i]);
                    if(set.add(newSubList))
                        curList.add(newSubList);
                }
                
                List<Integer> newSubList = new ArrayList<Integer>();
                newSubList.add(nums[a]);
                newSubList.add(nums[i]);
                if(set.add(newSubList))
                        curList.add(newSubList);
                
                map.put(nums[i], set);
            }
        }
        list.add(i, curList);
    }

	public static void main(String[] args) {
		new T491IncreasingSubsequences().findSubsequences(new int[] { 4, 6, 7, 7 });
	}
}
