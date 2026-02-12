class Solution {
    public int longestBalanced(String s) {
        int ans = 0; 
        
        for(int i =0 ; i < s.length(); i++){
            Map<Character , Integer> map = new HashMap<>();
            for(int j = i ; j < s.length() ; j++){
                char c = s.charAt(j);
                map.put(c , map.getOrDefault(c , 0) + 1);

                if(isBalanced(map)){
                ans = Math.max(ans , j-i+1);
                }
            }
        }
        return ans ; 
    }
    public boolean isBalanced(Map<Character , Integer> map){
        int firstFreq = -1;

        for(int freq : map.values()){
            if(firstFreq == -1){
                firstFreq = freq;
            }
            else if (firstFreq != freq){
                return false ; 
            }
        }
        return true; 
    }
}