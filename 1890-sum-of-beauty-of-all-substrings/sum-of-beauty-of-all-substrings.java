class Solution {
    public int beautySum(String s) {
        int count = 0 ; 
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            Map<Character , Integer> map = new HashMap<>();
            
            for(int j = i ; j < n ; j++ ){
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE; 
                char ch = s.charAt(j);
                map.put(ch , map.getOrDefault(ch , 0 ) + 1);
                if(map.size() > 1){
                    for(Map.Entry<Character,Integer> entry : map.entrySet()){
                        max = Math.max(max , entry.getValue());
                        min = Math.min(min , entry.getValue());
                    }
                }
                if(max - min > 0 && min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                    count+= max -min;

                }
            }
            
        }

        return count; 
    }
}