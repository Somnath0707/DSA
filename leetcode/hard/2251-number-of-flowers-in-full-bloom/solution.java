class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length ; 
        TreeMap<Integer,Integer> map = new TreeMap<>(); 
        for(int i = 0 ; i < n ; i++){
            int first = flowers[i][0]; 
            int last = flowers[i][1]; 
            map.put(first , map.getOrDefault(first , 0) +1); 
            map.put(last + 1 , map.getOrDefault(last+1 , 0)-1);
        }
        int curr = 0 ; 
        TreeMap<Integer,Integer> ans = new TreeMap<>(); 
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey(); 
            curr += entry.getValue(); 
            ans.put(key,curr); 
        }

        int m = people.length ; 
        int res[] = new int[m]; 
        for(int i = 0 ; i < m ; i++){
            int person = people[i]; 
            Integer key = ans.floorKey(person); 
            if(key == null){
                res[i] = 0 ; 
            }else{
                res[i] = ans.get(key); 
            }
        }
        return res; 
    }
}