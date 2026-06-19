class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort((items) , (a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return b[1] - a[1]; 
        });
        
        int prev = -1 ; 
        TreeMap<Integer ,Integer> map = new TreeMap<>(); 
        for(int i = 0 ; i < items.length ; i++){
            int price = items[i][0]; 
            int beauty = items[i][1];

            if(prev > beauty){
                map.put(price , prev);
            }
            else {
                map.put(price , beauty);
                prev = beauty; 
            }
        }

        int ans[] = new int[queries.length]; 

        for(int i = 0 ; i <queries.length ; i++){
            Integer key = map.floorKey(queries[i]);

            if(key != null){
                ans[i] = map.get(key);
            }
        }
        return ans;
    }
}