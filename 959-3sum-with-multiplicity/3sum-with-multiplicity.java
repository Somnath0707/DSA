class Solution {
    int MOD = 1000000007;
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>(); 
        for(int n : arr){
            map.put(n , map.getOrDefault(n , 0 ) + 1 ) ; 
        }
        int n = arr.length ; 
        int ans = 0 ; 
        for(int i = 0; i < n-2 ; i++){
            int num = arr[i]; 
            map.put(num , map.getOrDefault(num , 0 ) -1 ) ;
            if(map.get(num) == 0 ) map.remove(num);
            Map<Integer,Integer> temp = new HashMap<>(map); 
            for(int j = i+1 ; j < n ; j++){
                int find = target - (num + arr[j]); 
                temp.put(arr[j] , temp.getOrDefault(arr[j] , 0 ) -1 );
                if(temp.get(arr[j]) == 0 ) temp.remove(arr[j]);
                if(temp.containsKey(find)){
                    ans = (ans +  temp.get(find)) % MOD;
                }
            }
            
        }

        return ans; 
    }
}