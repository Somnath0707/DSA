class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // [1,4] [2,8] [3,6]
        Arrays.sort(intervals, (a,b)->{
            if (a[0]!=b[0]){
                return a[0] - b[0];// start ascending
            }
            return b[1]-a[1]; // end descending 
        });

        int lastEnd = intervals[0][1];
        int total = intervals.length ; 

        for(int i = 1 ; i < intervals.length ; i ++){
            int Scurr = intervals[i][0];
            int Ecurr = intervals[i][1];

            if(lastEnd>= Scurr && lastEnd >= Ecurr){
                total--;
            }else{
                lastEnd = Ecurr;
            }
        }
        return total ; 
    }
}