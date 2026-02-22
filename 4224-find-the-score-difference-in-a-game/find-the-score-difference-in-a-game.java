class Solution {
    public int scoreDifference(int[] nums) {
        int person1 = 0 ;
        int person2 = 0 ;
        Boolean active1 = true; 
        Boolean active2 = false;
        for(int i =0 ; i< nums.length ; i++){
            if(nums[i]% 2 != 0){
                active1 = !active1;
                active2 = !active2;
            }
            if(i%6 == 5){
                active1 = !active1;
                active2 = !active2;
            }
            if(active1) person1 += nums[i];
            if(active2) person2 += nums[i];
        }
        return (person1 - person2);
    }
}