class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0; 
        int j = 0 ;
        int diff = 0 ; 

        while(i < nums1.length && j < nums2.length ){
            int currDiff = 0 ; 
            if(i > j ){
                j++;
                continue;
            }
            if(nums1[i] > nums2[j]){
                i++;
                continue;
            }
            else if(nums1[i] <= nums2[j] && i <= j){
                currDiff = j - i ; 
                j++;
            }

            diff = Math.max(diff , currDiff);
        }

        return diff;
    }
}