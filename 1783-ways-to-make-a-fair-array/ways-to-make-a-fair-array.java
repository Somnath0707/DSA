class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEven = 0 ; 
        int totalOdd = 0; 

        for(int i =0 ; i < nums.length ; i++){
            if( i % 2 == 0){
                totalEven += nums[i];
            }else{
                totalOdd += nums[i];
            }
        }
        int currentEvenTotal = 0; 
        int currentOddTotal = 0;
        int count =0 ; 
        for(int i = 0;  i < nums.length ; i++){
             if(i % 2 == 0){
                 totalEven -= nums[i];
             }else {
                 totalOdd-= nums[i];
             }

            int evenAns = currentEvenTotal + totalOdd;
            int oddAns = currentOddTotal + totalEven;

            if(evenAns == oddAns){
                count ++;
                
            }

             if(i % 2 == 0) currentEvenTotal += nums[i];
            else currentOddTotal += nums[i];
        }

        return count ; 
    }
}