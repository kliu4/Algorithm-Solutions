package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Area {
	int start;
	int end;

	public Area(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public Area(int[] point) {
		this.start = point[0];
		this.end = point[1];
	}
}

public class T452MinNumberOfArrowsToBurstBalloon {
	public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                return p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0];
            }
        });
        
        List<Area> areas = new ArrayList<Area>();
        areas.add(new Area(points[0]));
        
        for(int i = 1; i < points.length; i++){
            Area area = areas.get(areas.size() - 1);
            if(points[i][0] >= area.start && points[i][0] <= area.end){
                area.start = points[i][0];
                area.end = Math.min(points[i][1], area.end);
            }
            else
                areas.add(new Area(points[i]));
        }
        
        return areas.size();
	}
}
