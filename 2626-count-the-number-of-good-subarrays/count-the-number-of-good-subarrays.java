class Solution {
    public long countGood(int[] nums, int k) {
        // go left to right then increasing go on reducing the map from left to right 

        // suppose I go left to right i have now 3 as freq 2 so total pair would be 1 if there is freq 3 then total pair would be 3 

        // 2 :1 , 3 : 2 , 4 : 6 ,  5 : 10 , 6 : 15 whats the formula ? 
        // its always for example for 5 its : 4 + 3 + 2 + 1  for 4 its 3 + 2 + 1 yeps its then  its n = 5-1 and then 4(4+1)/2  10 so its that 

        // so go left to right then and see all the pair and then go left to righ treducing the pair and get totoal 
        Map<Integer,Integer> map = new HashMap<>(); 
        long totalPair = 0 ; 
        long ans = 0 ; 
        int j = 0 ; 
        int n = nums.length ; 
        for(int i = 0 ; i < n ; i++){
            int val = nums[i];
            map.put(val , map.getOrDefault(val , 0)+1);

            if(map.get(val)>1){
                // totalPair -=
                if(map.get(val) == 2){
                    totalPair += 1 ; 
                }
                else{
                    long nRemove = 1L * map.get(val)-2;
                    long remove = 1L*  nRemove*(nRemove+1) / 2; 
                    totalPair -= remove; 
                    long nAdd = map.get(val)-1; 
                    long add = 1L* nAdd * (nAdd+1)/2; 
                    totalPair+= add; 
                }
            }
            boolean isDone = false; 
            while(totalPair >= k){
                ans+= n-i; 
                int freq = map.get(nums[j]);
                if(freq > 1){
                    if(freq == 2 ){
                        totalPair--; 
                    }
                    else{
                        long nRemove = freq-1; 
                        long remove = 1L * nRemove * (nRemove +1 ) /2 ; 
                        totalPair -= remove; 
                        long nAdd = 1L * freq - 2; 
                        long add = 1L * nAdd * (nAdd+1)/2; 
                        totalPair += add; 
                    }
                }
                map.put(nums[j] , freq-1);
                if(map.get(nums[j]) == 0) map.remove(nums[j]) ;
                j++; 
                isDone = true; 
            }


        }
        return ans; 
    }
}