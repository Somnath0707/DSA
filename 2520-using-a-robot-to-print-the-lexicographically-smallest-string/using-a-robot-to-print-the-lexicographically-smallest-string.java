class Solution {
    public String robotWithString(String s) {
        Map<Character , Integer > map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0 ) + 1 );
        }
        Stack<Character> st = new Stack<>();
        char minChar = 'a';
        StringBuilder res = new StringBuilder ();
        for(char ch : s.toCharArray()){
            st.push(ch);
            map.put(ch , map.getOrDefault(ch , 0 ) -1 );
            while(minChar !='z' && map.getOrDefault(minChar , 0) == 0 ) minChar++;
            while(!st.isEmpty() && minChar >= st.peek()){
                res.append(st.pop());
            }
        }
        return res.toString();
    }
}