class Solution:
    def maximumWidth(self, nums: list[int]) -> int:
        n = len(nums)
        
        width = {}
        
        used = {}
        
        for i in range(n):
            target = nums[i]
            
            if target not in used:
                used[target] = set()
            
            used[target].add(i)
            width[target] = width.get(target, 0) + 1
            
        for i in range(n):
            for j in range(i + 1, n):
                target = nums[i] + nums[j]
                
                if target not in used:
                    used[target] = set()
                    
                used_indices = used[target]
                
                if (i not in used_indices) and (j not in used_indices):
                    used_indices.add(i)
                    used_indices.add(j)
                    
                    width[target] = width.get(target, 0) + 1
                    
        ans = 0
        for w in width.values():
            ans = max(ans, w)
            
        return ans


    #     class Solution {
    # public int maximumWidth(int[] nums) {
    #     Map<Integer , Set<Integer>> map = new HashMap<>(); 
    #     Map<Integer , Integer> ans = new HashMap<>(); 
    #     int n = nums.length; 
    #     for(int i = 0 ; i < n ; i++){
    #         map.putIfAbsent(nums[i] , new HashSet<>()); 
    #         map.get(nums[i]).add(i); 
    #         ans.put(nums[i] , ans.getOrDefault(nums[i] , 0 ) +1);
    #         for(int j = i+1 ; j < n ; j++){
    #             int sum = nums[i] + nums[j]; 
    #             map.putIfAbsent(sum , new HashSet<>()); 
    #             if(!map.get(sum).contains(i) && !map.get(sum).contains(j)){
    #                 map.get(sum).add(i); 
    #                 map.get(sum).add(j); 

    #                 ans.put(sum , ans.getOrDefault(sum , 0) +1 ) ; 
    #             }
    #         }
    #     }
    #     int max = 0; 
    #     for(int temp : ans.values()){
    #         max = Math.max(temp , max); 
    #     }
    #     return max; 
    # }
# }©leetcode

# this got tle btw