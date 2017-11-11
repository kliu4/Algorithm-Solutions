package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class T692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word:words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(k, 
            new Comparator<Map.Entry<String, Integer>>(){
                @Override
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2){
                    return entry1.getValue() == entry2.getValue() ? entry1.getKey().compareTo(entry2.getKey()) : entry2.getValue() - entry1.getValue();
                }
        });
        
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < k && !queue.isEmpty(); i++)
            list.add(queue.poll().getKey());
        
        return list;
    }

	public static void main(String[] args) {
		new T692TopKFrequentWords().topKFrequent(new String[] { "I", "love", "I", "love", "leetcode", "coding" }, 2);
	}
}
