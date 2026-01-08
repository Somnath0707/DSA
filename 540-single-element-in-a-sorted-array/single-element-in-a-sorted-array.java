// We know few things here 
            // Array is sorted 
            // It says it need O(log n ) so it is giveaway use binary search dumbo
            
            //  0 1 2 3 4 5 6 7 8
            // [1,1,3,3,4,4,5,8,8]

            // Here we observe these sexy looking numbers 
            // Key point: evey one has couple(expect you and one number in the array)
            // We can understand that evey even index is followed by its pair until 
            // Until some loser comes and break the sequence 
            // We have to find the loser which break this pattern 
            // So before the loser every even index was follwed by the pair 
            // So we can place mid in even mid of array i.e. mid%2==0 if not mid--;
            // So once the mid is in even index if the mid + 1 == mid 
            // We know that till mid + 1 sequence is good and no loser has spawned
            // so we can just move our left to mid + 2;
            // If mid != mid + 1 we know some loser has spawned in mid or before mid
            // so we can do right = mid ;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0 ,
            right = nums.length-1 ; 

            

        while(left < right ){
            int mid = left + (right - left ) / 2;
            if(mid % 2 ==1 ){
                mid --;
            }
            if(nums[mid] == nums[mid + 1]){
                left = mid + 2; 
            }
            else {
                right = mid ;
            }
        }
        return nums[left];
    }
}