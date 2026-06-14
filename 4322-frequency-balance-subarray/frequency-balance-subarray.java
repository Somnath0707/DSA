class Solution {
    public int getLength(int[] nums) {
        int n = nums.length; 
        int ans = 0 ; 
        for(int i = 0 ; i < n ; i++){
            Map<Integer,Integer> map = new HashMap<>() ; 
            TreeMap<Integer,Integer> tree = new TreeMap<>();
            for(int j = i ; j < n ; j++){
                int key = nums[j];
                if(map.containsKey(key)){
                    int oldFreq = map.get(key);
                    tree.put(oldFreq , tree.get(oldFreq) - 1 ) ; 
                    if(tree.get(oldFreq ) == 0 ){
                        tree.remove(oldFreq);
                    }
                }

                map.put(key , map.getOrDefault(key , 0 ) + 1 ) ; 
                int newFreq = map.get(key); 
                tree.put(newFreq , tree.getOrDefault(newFreq , 0 ) + 1 ) ; 

                if(tree.size() ==1 ){
                    // if map has only one value that means there is only one number mutltiple times then 
                    if(map.size() == 1) {
                        ans= Math.max(ans ,j - i + 1 ); 
                    }
                    else 
                    ans = Math.max(ans , 1 ) ; 
                }
                if(tree.size() == 2 ) {
                    int maxVal = tree.lastKey(); 
                    int minVal = tree.firstKey() ; 

                    if(minVal * 2 == maxVal ) ans = Math.max(ans , j - i + 1 ) ; 
                }
            }
        }

        return ans; 
    }
}