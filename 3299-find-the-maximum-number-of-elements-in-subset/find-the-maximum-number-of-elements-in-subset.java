class Solution {
    public int maximumLength(int[] nums) {
        // 2 : 2 
        // 4 : 1 
        // 5 : 1
        // 1  2  2 4 5 
        Map<Integer,Integer> map = new HashMap<>(); 

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1 ) ; 
        }
        int ans = 0; 
        
        int arr[] = new int[map.size()]; 
        int ind = 0 ; 
        for(int n: map.keySet()){
            arr[ind++] = n; 
        }

        Arrays.sort(arr);

        if(map.containsKey(1)){
            int num = map.get(1);
            if(num %2 == 0) ans = num -1 ; 
            else ans = num ; 
        }

        for(int n : arr){
            if(n == 1 )continue; 
            if(map.get(n) >= 2){
                int collect = 0 ; 
                long next = n;

                while(map.containsKey((int)next)) {
                    int curr = map.get((int)next);
                    if(curr >= 2){
                        collect+=2 ; 
                        next = next * next ; 
                    }
                    else {
                        collect += 1; 
                        break ; 
                    }
                }
                if(collect %2 == 0 ){
                    collect-=1 ; 
                }
                ans = Math.max(ans , collect ) ; 
            }
        }
        if(ans == 0 ) return 1 ; 
        return ans;
    }
}