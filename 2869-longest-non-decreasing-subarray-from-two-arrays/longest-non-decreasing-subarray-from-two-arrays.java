class Solution {
    int n = 0 ; 
    Map<String,Integer> dp; 
    public int f(int i , int prev , int nums1[] , int nums2[]){
        if(i == n ) return 0 ; 
        String key = i + "#" + prev; 
        int take = 0 ; 

        
        if(nums1[i] < prev && nums2[i] < prev && prev != Integer.MAX_VALUE ) return 0 ; 
        if(dp.containsKey(key)) return dp.get(key);

        else if(prev == Integer.MAX_VALUE ){
             take = Math.max(f(i+1 , prev , nums1 , nums2) ,Math.max(1 + f(i+1 , nums1[i] , nums1 , nums2) , 1 + f(i+1 , nums2[i] , nums1 , nums2)));
        }
        

        else if((nums1[i] >= prev && nums2[i] >= prev )|| prev == Integer.MAX_VALUE){
            // System.out.println(" This is the take when both have great value " + i );
            take = Math.max(1 + f(i+1 , nums1[i] , nums1 , nums2) , 1 + f(i+1 , nums2[i] , nums1 , nums2));
        }
        else if(nums1[i] >= prev ){
            take = 1 + f(i+1 , nums1[i] , nums1 , nums2);
        }
        else if(nums2[i] >= prev){
           take =  1 + f(i+1 , nums2[i] , nums1 , nums2);
        }
        dp.put(key , take) ;
        return take ; 
    }
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        n = nums1.length;
        dp = new HashMap<>(); 
        return f(0, Integer.MAX_VALUE , nums1 , nums2);
    }
}