package leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class T632SmallestRange {
	class Point{
        int val;
        int index;
        int row;
        
        public Point(int val, int index, int row){
            this.val = val;
            this.index = index;
            this.row = row;
        }
    }  
        
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>(nums.size(), new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.val - p2.val;
            }
        });
        
        int maxVal = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i).get(0) > maxVal)
                maxVal = nums.get(i).get(0);
            queue.offer(new Point(nums.get(i).get(0), 0, i));
        }
        
        int minR = maxVal - queue.peek().val;

        int resultMax = maxVal;
        
        while(true){
            if(minR == 0)
                break;
            Point minPoint = queue.poll();
            int newIndex = minPoint.index + 1;
            int newRow = minPoint.row;

            if(newIndex >= nums.get(newRow).size())
                break;
                        
            int newVal = nums.get(newRow).get(newIndex);
            maxVal = Math.max(newVal, maxVal);
            
            queue.offer(new Point(newVal, newIndex, newRow));
            if(minR > maxVal - queue.peek().val){
                minR = maxVal - queue.peek().val;
                resultMax = maxVal;
            }
        }
        
        return new int[]{resultMax - minR, resultMax};
    }
}
