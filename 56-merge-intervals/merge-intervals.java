class Solution {
    public int[][] merge(int[][] intervals) {

        //Sort the array in the Ascending form 
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        // Create a List of array (as the interval is in array) to store the elements 
        List<int[]> list = new ArrayList<>();

        // Add the first interval from the sorted intervals
        list.add(intervals[0]);

        // [1,3] this is the list 

        for(int i = 1 ; i < intervals.length; i++){

            // Get the previous from the list 
             // [1,3],[2,6],[8,10],[15,18]] 
            int[] prev = list.get(list.size() - 1 ); // From above the [1,3] is the 0 in the list
            int[] curr = intervals[i]; // The interval in i th place [2,6]

            // The start of the Second is less then end of first here :[1,3] [2,6]
            // curr[0] is 2 i.e. start of curr
            //prev[1] is 3 i.e. end of the prev 
            // As here the start of 2nd array is small than end of 1 st we can tell they overlap
            if(curr[0]<=prev[1]){

                // Take the start the minimum of the 2 comparing array 
                // [1,3] [2,6] -> min(1,2)->1 so merged array [1,X]
                prev[0] = Math.min(prev[0],curr[0]);

                // For the next 'X' we have to take the max of both the array
                // [1,3] [2,6] -> max(3,6)->6 so merged array [1,6]
                prev[1] = Math.max(prev[1],curr[1]);

                // So after this our new array in the list becomes merged: ([1,6])
            }
            // Else they do not over lap 
            else{
                list.add(intervals[i]);
            }
        }

        int [][] res = new int [list.size()][2];

        for(int i = 0 ; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res; 

    }
}