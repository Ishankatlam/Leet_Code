import java.time.LocalTime;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        
      List<LocalTime> times = new ArrayList<>();
        for (String timeStr : timePoints) {
            times.add(LocalTime.parse(timeStr));
        }

     
        Collections.sort(times);

        int minDifference = Integer.MAX_VALUE;

    
        for (int i = 1; i < times.size(); i++) {
            int diff = (int) Duration.between(times.get(i - 1), times.get(i)).toMinutes();
            minDifference = Math.min(minDifference, diff);
            
    
            if (minDifference == 0) return 0;
        }


        int circularDiff = (int) (Duration.between(times.get(times.size() - 1), LocalTime.MAX).toMinutes() 
                           + Duration.between(LocalTime.MIDNIGHT, times.get(0)).toMinutes() + 1);
        
        minDifference = Math.min(minDifference, circularDiff);

        return minDifference;
    }
}