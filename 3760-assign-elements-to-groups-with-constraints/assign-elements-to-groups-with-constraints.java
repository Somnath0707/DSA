class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        // If i dont solve this on my own I am gay fsss

        // 8 -> 2 , 4 , 8 element[4,2] so 2 and 4 is in the list but the 4 comes first so we take that 

        int n = groups.length; 
        int m = elements.length; 
        Map<Integer , Integer> map = new HashMap<>() ; 
        for(int i = 0 ; i < m ; i++){
            int num = elements[i]; 
            // we map each element to its index 
            if(!map.containsKey(num))
                map.put(num , i );
        }

        int ans[] = new int[n]; 
        // initally no one has the belong to any group 
        Arrays.fill(ans , Integer.MAX_VALUE ) ; 

        for(int i = 0 ; i < n ; i++){
            int num = groups[i];
            for(int j = 1 ; j * j <= num ; j++){
                if(num % j == 0 ){
                    if(map.containsKey(j)){
                        ans[i] = Math.min(ans[i] , map.get(j));
                    }
                    if(j != num/j){
                        if(map.containsKey(num/j)){
                            ans[i] = Math.min(ans[i] , map.get(num/j));
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1 ; 
        }
    return ans; 
    }
}