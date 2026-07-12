class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int temp[] = arr.clone(); 
        Arrays.sort(temp);
        Map<Integer,Integer> map = new HashMap<>();
        int rank = 1 ; 
        int n = arr.length; 
        for(int i = 0 ; i < n ; i++){
            if(!map.containsKey(temp[i]))
            map.put(temp[i] , rank++);
        }
        int ans[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}