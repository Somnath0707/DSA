class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int max = 0 ; 
        int nonMax = 0 ; 
        int maxAll = 0 ; 
        int j = 0 ; 
        int n = nums.size();
        for(int i = 0 ; i < n ; i++){
            
            while(j < n ){
                int val = nums.get(j);

                map.put(val , map.getOrDefault(val , 0) + 1 ) ; 
                max = Math.max(map.get(val) , max );

                

                nonMax = j-i+1 - max; 
                // System.out.println(val  + " " + max + " " + j + " " + i  + " " + nonMax);
                j++; 

                if(nonMax > k) break;
            }
            maxAll = Math.max(max , maxAll);
            // System.out.println("Oustside");
            //  System.out.println(nums.get(i) +  " " + max + " " + j + " " + i  + " " + nonMax);
            
            map.put(nums.get(i) , map.get(nums.get(i)) - 1);

            // if(j == n-1)break;

        }

        return maxAll; 
    }
}


// 4 4 4 4 2 3 2 6 k = 2