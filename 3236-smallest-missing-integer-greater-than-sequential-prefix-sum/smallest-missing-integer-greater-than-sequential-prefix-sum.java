class Solution {
    public int missingInteger(int[] nums) {
        // Question say that starting from from the 0 th index take a substring that that should be = previous + 1 and if true add them to the sum 
        // if the logic fail "if the sum in present in the map increment it till it doesnt int the array "

        //We can create a set put all the element in the set 
        // then go through then we see the 1 <= nums.length <= 50 constraints so it array could be of 1 length too so we put that in the sum and then loop over the rest of the element until the logic and keep adding to the sum 
        // after that we keep increase sum until it doesnt contain in the array 

        // Create a set to store the unique number from the array 
        Set<Integer> set = new HashSet<>();

        // put the nums in the set 
        for(int n : nums){
            set.add(n);
        }

        // make the sum var and put the value the initial value in it so for the future kids to check based on it 
        int sum = nums[0];

        // loop over the nums and check for the condition 
        for(int i = 1 ; i< nums.length ; i++){
            // check for the condition nums[j] = nums[j - 1] + 1
            if(nums[i] == nums[i-1] + 1) sum += nums[i];
            // else if the condition is not satisfied then we break
            else break ; 
        }

        // no we have the sum so check if the sum exist in the set if so increment the sum
        while(set.contains(sum)){
            sum++;
        }
        return sum; 
    }
}