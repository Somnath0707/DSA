class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndx = -1;
        int maxIndx = -1; 

        for(int i = 0 ; i < nums.length ; i++){

            // ✅ Only add VALID candidates
            if(i >= indexDifference){
                int val = nums[i - indexDifference];

                if(val < min){
                    min = val;
                    minIndx = i - indexDifference;
                }

                if(val > max){
                    max = val;
                    maxIndx = i - indexDifference;
                }
            }

            // ✅ Only check when we have valid candidates
            if(minIndx != -1){
                int diffMin = Math.abs(min - nums[i]);
                int diffMax = Math.abs(max - nums[i]);

                if(diffMin >= valueDifference){
                    return new int[]{i , minIndx};
                }

                if(diffMax >= valueDifference){
                    return new int[]{i , maxIndx};
                }
            }
        }
        return new int[]{-1 , -1 };
    }
}