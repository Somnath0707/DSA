class Solution {
    public String sortVowels(String s) {
        Map<Character ,Integer> map = new HashMap<>();
        Map<Character , Integer> firstOcc = new HashMap<>();
        int ind = 0 ; 
        for(char ch : s.toCharArray()){
            if(ch =='a' || ch == 'e' || ch =='i' || ch =='o' || ch == 'u'){
                map.put(ch , map.getOrDefault(ch , 0)+1);
                firstOcc.putIfAbsent(ch ,ind++);
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a,b)-> {
            if(!map.get(a).equals(map.get(b))) return map.get(b) - map.get(a);
            return firstOcc.get(a) - firstOcc.get(b);
        });

        List<Character> order = new ArrayList<>();
        for(char ch : list){
            int count = map.get(ch);

            while(count-- > 0 ){
                order.add(ch);
            }
        }

        StringBuilder str = new StringBuilder(s);

        int indx = 0 ; 

        for(int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch =='a' || ch == 'e' || ch =='i' || ch =='o' || ch == 'u'){
                str.setCharAt(i , order.get(indx++));
            }
        }

        return str.toString();
    }
}
