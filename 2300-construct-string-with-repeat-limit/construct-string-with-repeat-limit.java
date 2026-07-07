class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // return "";
        Map<Character , Integer> map = new HashMap<>(); 

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0 ) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0] - a[0]);

        for(Map.Entry<Character , Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey() , entry.getValue()});
        }
        StringBuilder str = new StringBuilder(); 
        char prev = '#';
        while(!pq.isEmpty()){
            int temp[] = pq.poll(); 
            char ch = (char)temp[0];
            int val = temp[1]; 
            int curr = Math.min(val , repeatLimit);
            if(prev == ch) curr-=1 ; 
            for(int i = 0 ; i < curr ; i++){
                str.append(ch);
            }
            int newVal = val - curr; 
            if(prev == ch) newVal+=1 ; 
            if(newVal > 0 ){
            if(pq.isEmpty())break; 
            int temp2[] = pq.poll();
            char ch2 = (char)temp2[0]; 
            int val2 = temp2[1]; 
            str.append(ch2);

            int newVal2 = val2-1; 
            prev = ch2; 
            if(newVal != 0 ) pq.offer(new int[]{ch , newVal});
            if(newVal2 != 0 ) pq.offer(new int[]{ch2 , newVal2});
            }
            else 
            prev = ch;
        }

        return str.toString(); 
    }
}