class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length ;
        int prefixSum1 []= new int[n];
        int prefixSum2[] = new int[n];
        int maxSum1 = 0 ; 
        int maxSum2 = 0 ; 

        for(int i =0 ; i< n ; i++){
            prefixSum1[i] = nums1[i] - nums2[i];
            prefixSum2[i] = nums2[i] - nums1[i];
            maxSum1+=nums1[i];
            maxSum2+= nums2[i];
        }

        int maxAns = Integer.MIN_VALUE;
        boolean previous = false ;
        int prevAns = maxSum1;
        for(int i = 0 ; i < n ; i++){
            // if the previous value was also negative keep the ans and keep on adding to it 
            prevAns += -prefixSum1[i];
            if(prevAns < maxSum1){
                prevAns = maxSum1 ; 
            }
            maxAns = Math.max(maxAns , prevAns);
                
        }

        previous = false ;
        int prevAns2 = maxSum2 ; 
        int maxAns2 = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){

            prevAns2 += -prefixSum2[i];
            if(prevAns2 < maxSum2){
                prevAns2 = maxSum2;
            }
            maxAns2 = Math.max(maxAns2 , prevAns2);
                
            
        }

        int ans =Math.max(maxAns2 , maxAns);
        if( ans <0 )  ans = Math.max(maxSum1 , maxSum2);

        return ans ; 
        
    }
}