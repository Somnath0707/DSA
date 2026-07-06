class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0] ,b[0]);
            return b[1] - a[1]; 
        });

        int prevStart = intervals[0][0]; 
        int prevEnd = intervals[0][1]; 
        
        int n = intervals.length;
        int count = 0 ; 
        for(int i = 1 ; i < n ; i++){
            int currStart = intervals[i][0]; 
            int currEnd = intervals[i][1]; 
            if(currStart >= prevStart && currEnd <= prevEnd) count++; 

            if(prevEnd >= currStart){
                prevStart = Math.min(currStart , prevStart);
                prevEnd = Math.max(currEnd , prevEnd);
            }

        }


        return n - count; 
    }
}


// 1,4. 2,8 ,  3,6