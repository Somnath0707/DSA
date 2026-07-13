import java.util.*;

class Solution {
    public String minimizeStringValue(String s) {
        int n = s.length(); 
        Map<Character , Integer> map = new HashMap<>(); 
        int countQues = 0 ; 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if( ch != '?')
            map.put(ch , map.getOrDefault(ch , 0)+1);
            else countQues++; 
        }

        int add = 26 - map.size() ; 
        PriorityQueue<Character> pCh = new PriorityQueue<>(); 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0] , b[0]);
            return a[1] - b[1]; 
        });
        for(char i = 'a' ; i <= 'z'   ; i++){
            if(!map.containsKey(i)) pCh.offer(i); 
            else{
                int val = map.get(i);
                pq.offer(new int[]{val , i});
            }
        } 

        List<Character> list = new ArrayList<>(); 
        StringBuilder str = new StringBuilder(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(ch != '?') continue;
            else{
                if(!pCh.isEmpty()){
                    char val = pCh.poll();
                    list.add(val);
                    pq.offer(new int[]{1 , val}); // Now it has freq 1, so it goes to pq
                }
                else {
                    int temp[] = pq.poll();
                    int val = temp[0];
                    char put = (char)temp[1]; 
                    list.add(put);
                    pq.offer(new int[]{val+1 , put});
                }
            }
        }

        Collections.sort(list);
        int ind = 0 ; 
        for(int i = 0 ; i< n ; i++){
            char ch = s.charAt(i);
            if(ch != '?') str.append(ch);
            else str.append(list.get(ind++));
        }

        return str.toString(); 
    }
}