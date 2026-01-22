class Solution {


    // A function to check if the list is sorted 
    public boolean isSorted(List<Integer> list ){
        for(int i = 0 ; i < list.size() -1 ; i++){
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true; 
    }
    public int minimumPairRemoval(int[] nums) {
        // We need to do many set and replace operation so array aint gonna cut it 
        List<Integer> list = new ArrayList<>();

        // Create counter to store the count 
        int counter = 0 ; 

        // add the no in the list 
        for(int n : nums){
            list.add(n);
        }

        // If the list is not sorted then we need to do some nasty stuff 😈

        while(!isSorted(list)){
            // an variable to store the min sum 
            int minSum = Integer.MAX_VALUE;

            // and variavle to keep the index where we found the pair with smallest sum 
            int indx = -1;

            // A loop to go through them and find the minSum pair 
            for(int i =0 ; i < list.size() - 1 ; i ++){
                // A temp var to keep the current sum 
                int sum = list.get(i) + list.get(i+1);

                // if we get the minimum sum
                if(sum<minSum){
                    // update the min sum 
                    minSum = sum ; 

                    //keep a track where we got it cause we are gonna touch him 🌚
                    indx = i ; 
                }
            }

            // Now it time to replace the both of the no from which we got the minimum sum 

            list.remove(indx+1);
            list.set(indx , minSum);
            counter  ++; 
        }
    return counter ; 
        
    }
}




// Check if the array is already sorted in the asecneding / increasing order 
        //If yes return count = 0  ;
        // If no go through all of them one by one check if and sum the each one find the min pair 
        // replace the i with there sum and index + 1 remove it 
    // and keep on increasing the counter 
        // and chceck again if the list is sorted  and keep it doing all the way till the list is sorted of you die 