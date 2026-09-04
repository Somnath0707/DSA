class Solution {
    Map<Integer,Integer> map; 

    public boolean check(Map<Integer,Integer> temp ){
       for(int num : temp.values()){
            if(num != 0 ) return false; 
       }
       return true;
    }
    public int f(int i ,  int [][] nums , Map<Integer,Integer> temp){
        if(i == nums.length){
            if(check(temp)) return 0 ; 
            return Integer.MIN_VALUE; 
        }

        int take = 0 ; 
        int skip = 0 ; 
        int from = nums[i][0]; 
        int to = nums[i][1];
        temp.put(from, temp.getOrDefault(from, 0)-1) ;
        temp.put(to , temp.getOrDefault(to , 0)+1);
        take = 1 + f(i+1 , nums , temp); 

        temp.put(to , temp.get(to)-1);
        temp.put(from , temp.get(from)+1); 
        skip = f(i+1 , nums , temp);

        return Math.max(take , skip); 
    }
    public int maximumRequests(int n, int[][] req) {
        map = new HashMap<>(); 

        for(int i = 0 ; i < n ; i++){
            map.put(i , 0); 
        }

        return f(0 , req , map); 
    }
}