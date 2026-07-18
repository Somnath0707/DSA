class Solution {
    public boolean check(Map<Character , Integer> map , Map<Character , Integer> check){
        for(Map.Entry<Character , Integer> entry : check.entrySet()){
            char key = entry.getKey(); 
            if(map.get(key) != check.get(key)){
                return false; 
            }
        }
        return true; 
    }
    public List<Integer> partitionLabels(String s) {
        int i = 0 ; 
        int j = 0 ; 
        Map<Character , Integer> map = new HashMap<>(); 
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0 ) + 1 ); 
        }
        int n = s.length(); 
        Map<Character , Integer> check = new HashMap<>(); 
        List<Integer> list = new ArrayList<>(); 
        while(j < n ){
            char ch = s.charAt(j);
            check.put(ch , check.getOrDefault(ch , 0 ) + 1 );

            if(check(map, check)){
                list.add(j-i+1);
                i=j+1 ; 
            }
            j++;
        }
        return list; 
    }
}