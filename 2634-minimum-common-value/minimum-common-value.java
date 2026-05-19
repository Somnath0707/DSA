class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums2){
            set.add(n);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums1.length; i++){
            int currNum = nums1[i];
            if(set.contains(currNum)){
                min = Math.min(min , currNum);
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}