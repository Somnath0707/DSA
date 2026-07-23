class Solution {
    public int maximumRobots(int[] nums, int[] runningCosts, long budget) {
        // we have n robots 
        // we haeve 0 index array chage times and running costs 

        // we multiply the running cost our primary goal should to keep the running cost as low as possible to keep withwith the budget 
        // we we should also try to keep the charget Times in limit
        // 1 <= chargeTimes[i], runningCosts[i] <= 105 this tells ue that prefix sum is very much possible so ok ok ig

        // also feels like sliding window but with sums too 
        // so could slididng window + prefix sum just be it 
        int n = nums.length; 
        long prefixSum[] = new long[n] ; 
        prefixSum[0] = runningCosts[0]; 
        for(int i= 1 ; i < n ; i++){
            prefixSum[i] = (long)prefixSum[i-1] + (long)runningCosts[i];
        }

        int i = 0 ; 
        TreeMap<Integer , Integer> map = new TreeMap<>(); 
        // int max = -1; ÷÷÷÷÷≥≥≤˛˜˘ˇ¸.ƒˇƒˍ©¨¥˳þ`
        int ans = 0 ; 
        for(int j = 0 ; j < n ; j++){
            int val = nums[j]; 
            map.put(val , map.getOrDefault(val , 0) + 1 ) ; 
            long runSum = 0 ; 
            if(i == 0 ){
                runSum = prefixSum[j]; 
            }else{
                runSum = prefixSum[j] - prefixSum[i-1];
            }
            long calc = 1L * (long)map.lastKey() + (long)(j-i+1) * (long)runSum; 
            if(calc > budget){
                while(calc > budget && j < n && i < n ){
                    if(i > j) {
                        j++; 
                        map.put(nums[j] , map.getOrDefault(nums[j] , 0 ) + 1 ) ; 
                    }
                    map.put(nums[i] , map.get(nums[i])-1);
                    if(map.get(nums[i])== 0) map.remove(nums[i]);
                    i++; 
                    if(i == 0 ){
                        runSum = prefixSum[j]; 
                    }else{
                        runSum = prefixSum[j] - prefixSum[i-1];
                    }
                    if(map.isEmpty()) break; 
                    calc = (long)map.lastKey() + (long)(j-i+1) * (long)runSum;
                }
            }
            ans = Math.max(ans , j-i+1);
        }
        return ans; 
    }
}