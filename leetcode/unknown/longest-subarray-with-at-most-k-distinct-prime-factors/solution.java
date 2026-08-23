class Solution {
    public List<Integer> isPrime(int n){
        List<Integer> list = new ArrayList<>(); 

        for(int i = 2 ; i * i <=n ; i++){
            if(n % i == 0){
                list.add(i); 

                while(n % i  == 0){
                    n/=i; 
                }
            }
        }
        if(n > 1){
            list.add(n); 
        }
        return list; 
    }
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length; 
        List<List<Integer>> list = new ArrayList(); 
        for(int i = 0 ; i < n ; i++){
            list.add(isPrime(nums[i]));
        }

        int l = 0 ; 
        int ans = 0 ; 
        Map<Integer,Integer> map = new HashMap<>(); 
        for(int i = 0 ; i < n ; i++){
            for(int num : list.get(i)){
                map.put(num , map.getOrDefault(num , 0) + 1);
            }

            while(map.size() > k){
                for(int num : list.get(l)){
                    map.put(num , map.get(num)-1); 
                    if(map.get(num) == 0 ) map.remove(num); 
                }
                l++;
            }

            ans = Math.max(ans , i-l+1); 
        }

        return ans; 
    }
}