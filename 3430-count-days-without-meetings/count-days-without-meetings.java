class Solution {
    public int countDays(int days, int[][] meetings) {
        

        Arrays.sort(meetings , (a,b) -> a[0]-b[0]);

        // [1,3] [5,7] [9,10]

        
        // Instead of keeping track of previous everytime we just get the lastEnd and update it further
        int lastEnd = meetings[0][1];
        // Keep track of the free days 
        int freedays = 0 ; 

        // As we have kept the track of the first one End i.e. Last end we start from 1
        for(int i = 1; i< meetings.length; i++){

            // value of the i = 1's start node
            int Scurr = meetings[i][0];
            int Ecurr = meetings[i][1];
            // value of the i = 1's end node
            



            // We only calcuate if they do not over lap 
            // We know if the Start of current array is greater than the end of previous 
            // It does not overlap
            if(Scurr > lastEnd){
                // So to calcutate we need to get the Curr - last -1 you can try dumbo 
                freedays += Scurr - lastEnd-1;

            // Then here we uppdate the last End before we move to next array for comprasion
                lastEnd = Ecurr; 
            } 

            // Else we know they do overlap 
            else{
                // If they over lap we need to update the last End 

                // Ex : [1,5][3,4][6,7] here lastEnd is 5 and Scurr is 3 
                // They overlap so wee take max of [5,4] to make last end so they kinda merge
                // Last end = 5 , Scurr = 6

                lastEnd = Math.max(Ecurr, lastEnd);
            }
            
        }
        freedays += meetings[0][0] - 1;  // Suppose meeting starts day 3 so the free day = 2
        freedays += days - lastEnd ; // Suppose days = 5  , lastDay meeting = 4 so 5-4 = 1

        return freedays;
        
    }
}