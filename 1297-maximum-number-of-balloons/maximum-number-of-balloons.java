class Solution {
    public int maxNumberOfBalloons(String text) {
        int count = Integer.MAX_VALUE; 
        Map<Character ,Integer> map = new HashMap<>();
        for(char ch : text.toCharArray()){
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch =='n'){
                map.put(ch , map.getOrDefault(ch , 0 ) + 1 ) ; 
            }
        }


        if(map.size() < 5)return 0 ;
        for(Map.Entry<Character , Integer> entry : map.entrySet()){
            char ch = entry.getKey(); 
            int val = entry.getValue(); 
            if(ch == 'l' || ch == 'o'){
                
                count = Math.min(count , val / 2);
            }
            else {
                count = Math.min(count , val);
            }

        }

        return count; 
    }
}