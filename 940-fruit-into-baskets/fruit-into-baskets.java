class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer , Integer> map = new HashMap<>();
        int n = fruits.length;
        int left = 0; 
        int ans = Integer.MIN_VALUE;

        for(int right = 0 ; right  < n ; right++){
            int r = fruits[right];
            map.put(r , map.getOrDefault(r , 0 ) + 1);

            while(map.size() > 2){
                int l = fruits[left];
                map.put(l , map.get(l) -1);

                if(map.get(l) == 0){
                    map.remove(l);
                }

                left ++;
            }

            ans = Math.max(ans , right - left + 1);
        }
        return ans ;  
    }
}