class Solution {
    public String[] largestString(int[] nums) {
        // 1 -> a 2-> b 4-> c 

        // so 2 4 8 16 32 64 128 etc then we can get the folliwing value 
        // remove that first 
        int n = nums.length; 
        TreeMap<Long , Character> map = new TreeMap<>(); 
        long ind = 1 ; 
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            map.put(ind , ch);
            ind*= 2; 
        }
        String ans[] = new String[n]; 
        for(int i =0 ; i < n ;i++){
            long curr = nums[i]; 
            StringBuilder str = new StringBuilder(); 
            while(curr != 0){
                long key = map.floorKey(curr); 
                curr -= key;
                str.append(map.get(key));   
            }
            ans[i] = str.toString(); 
        }
        return ans; 
    }
}