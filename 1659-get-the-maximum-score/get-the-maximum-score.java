class Solution {
    Map<Integer,Integer> map2 ;
    int n  ;
    int m; 
    Map<Integer,Integer> map1 ;
    Long dp[][]; 
    int MOD = 1000000007;
    public long f(int i , int arr , int nums1[] , int nums2[]){
        if(arr == 1 && i == n) return 0 ; 
        if(arr == 2 && i == m) return 0 ; 
        if(dp[i][arr] != null) return dp[i][arr]; 
        long take = 0 ; 
        if(arr == 0 ){
            take = Math.max(nums1[i] + f(i+1 , 1 , nums1 , nums2) , nums2[i] + f(i+1 , 2 , nums1 , nums2)); 
        }
        else{
            if(arr == 1 && map2.containsKey(nums1[i])){
                take = 1L * nums1[i] + Math.max(f(i+1 , 1 , nums1 , nums2) , f(map2.get(nums1[i])+1 , 2 , nums1 ,nums2 ));
            }
            else if( arr == 2 && map1.containsKey(nums2[i])){
                take = 1L * nums2[i] + Math.max(f(map1.get(nums2[i])+ 1 , 1 , nums1 , nums2) , f(i+1 , 2 , nums1 , nums2) );
            }
            else if(arr == 1){
                take = 1L * nums1[i] + f(i+1 , 1 , nums1 , nums2);
            }
            else {
                take = 1L * nums2[i] + f(i+1 , 2 , nums1 , nums2); 
            }
        }
        return dp[i][arr] = take ; 
    }
    public int maxSum(int[] nums1, int[] nums2) {
        map1 = new HashMap<>(); 
        map2 = new HashMap<>();
        n = nums1.length ; 
        m = nums2.length ; 
        int max = Math.max(n , m);
        dp = new Long[max][3]; 
        for(int i = 0 ; i < n ; i++){
            map1.put(nums1[i] , i) ;
        }
        for(int i = 0 ; i < m ; i++){
            map2.put(nums2[i] , i);
        }
        return (int)(f(0 , 0 , nums1 , nums2) % MOD);
    }
}