class Solution {
    public int numFriendRequests(int[] nums) {
        int n = nums.length ; 
        int temp[] = new int[121]; 
        for(int nu : nums){
            temp[nu]++; 
        }
        int prefixSum[] = new int[121]; 
        prefixSum[0] = temp[0]; 
        for(int i = 1 ; i < 121 ; i++){
            prefixSum[i] = temp[i] + prefixSum[i-1]; 
        }
        int ans = 0 ; 
        for(int i = 0; i < n ; i++){
            int first = nums[i] / 2 + 7;
            int second = nums[i]; 
            if(nums[i] < 100){
                second = Math.min(100 , nums[i]);
            }
            int count =  prefixSum[second]-prefixSum[first]-1; 
            if(count>0)
                ans+=count;
            
        }

        return ans; 
    }
}


// condtion can be age/2 + 7 > and curr age > 

// we have find person who is greater thatn first dcondtion and less than equal to second aside from itself and 

// i cant send req if my age is < 100 and other is > 100
// so  i can send req to those so if my age greater than 100 then i can send req to any one 