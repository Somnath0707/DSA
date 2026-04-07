class Solution {
    Map<String , Integer> map ;
    public int f(int i  , int prev , int count ,  int nums1[] , int nums2[] ){
        if(i >= nums1.length ) return count;
        String key = i + "#" + prev ;
        int take1 = 0, take2 = 0;

        if(map.containsKey(key)) return map.get(key);

        if(nums1[i] >= prev){
            take1 = f(i+1 , nums1[i], count + 1 , nums1 , nums2 );
        }

        if(nums2[i] >= prev){
            take2 = f(i+1 , nums2[i], count + 1 , nums1 , nums2 );
        }

        int ans =  Math.max(count, Math.max(take1, take2));
        map.put(key , ans);
        return ans ; 


    }
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        map = new HashMap<>();
        for(int i = 0 ; i < nums1.length ; i++){
            max = Math.max(max , f(i , -1 , 0 ,nums1 , nums2));
        }
        return max ; 
    }
}