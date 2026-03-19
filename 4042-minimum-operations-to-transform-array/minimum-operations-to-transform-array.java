class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums2.length;
        //take the element that is closet to the last and append it to the last of nums 2 for each op
        // before and after each operstion check if the number is closest to the last of the nums 2 the one closet to the nums2s last appendt it to the last of num1 and after each operation 

        long count = 0; 
        int target = nums2[n-1];
        
        long best = Long.MAX_VALUE;
        
        boolean isInRange = false;
        for(int i = 0 ; i< nums1.length ; i++){

            // check the first element 
            int checkDiff = nums2[i] - nums1[i];
            count += Math.abs(checkDiff);

            int a = nums1[i];
            int b = nums2[i];

            if(Math.min(a , b ) <= target && Math.max(a , b ) >= target){
                isInRange = true; 
            }
            best = Math.min(best, Math.min(
                                                Math.abs(nums2[i] - target),
                                                Math.abs(nums1[i] - target)
                                            ));
        }
        if(isInRange){
                return count + 1;
        }

        return count + best + 1 ; 
    }
}