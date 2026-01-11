class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

    // Sort the array in such a way that the Start should be ascending and end by decending 
        // You might be like: "wtf does this mean?" 😄
        // Relax. Why fear when I am here.

        // Example:
        // [[1,2], [3,4], [1,4]]

        // If we sort ONLY by start (ascending):
        // Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // Result becomes:
        // [[1,2], [1,4], [3,4]]

        // ❌ Problem:
        // Both [1,2] and [1,4] start at 1,
        // but the smaller interval [1,2] comes first.
        // This can break logic in problems like:
        // - Merge Intervals
        // - Remove Covered Intervals
        // - Interval Scheduling

        // ✅ Correct idea:
        // If two intervals have the SAME start,
        // the BIGGER interval should come first.

        // So we:
        // 1️⃣ Sort start in ascending order
        // 2️⃣ If starts are equal, sort end in DESCENDING order

        // Final correct order:
        // [[1,4], [1,2], [3,4]]


        Arrays.sort(intervals, (a,b)->{
            if (a[0]!=b[0]){
                return a[0] - b[0];// start ascending
            }
            return b[1]-a[1]; // end descending 
        });

        // Place last End to the first arrays end to compare to the Start of the next;
        int lastEnd = intervals[0][1];

        //To keep the track of total 
        int total = intervals.length ; 

        for(int i = 1 ; i < intervals.length ; i ++){
            int Scurr = intervals[i][0];
            int Ecurr = intervals[i][1];


            // Check if the next falls between the last 
            // Example [[1,4], [1,2]] lastEnd = 4 , Scurr = 1 , Ecurr = 2;
            // if 1<4 and 2 is also less than 4 so it is inside the the first array 
            if(lastEnd>= Scurr && lastEnd >= Ecurr){
                // We decrease the total 
                total--;
            }else{

                // Else we know it is not inside the array and we go to next array 
                lastEnd = Ecurr;
            }
        }
        return total ; 
    }
}