class Solution {
    public int maxProduct(int[] nums) {
        int prefixMul = 1; 
        int suffixMul = 1; 
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i =0 ; i < nums.length ; i++){
            if(prefixMul == 0) prefixMul = 1 ; 
            if(suffixMul == 0 ) suffixMul = 1; 
            prefixMul = nums[i] * prefixMul;
            suffixMul= nums[n - i-1] * suffixMul;

            maxProduct = Math.max(maxProduct  , Math.max(suffixMul , prefixMul));
        }
        return maxProduct ; 
    }
}