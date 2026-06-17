class Solution {
    public String clearStars(String s) {
        // If I dont do this I should kill my self and die fck it 
        // we have to remove the leftmost * an dthe smallest leftmost element to its left
        // we put it in heap and sort by the char and then by its index i.e ascedning by the char and descending by the index 
        // as per the * remove from heap till that ponint and store the index in list to later remoe them from the string 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            if(a[0] != b[0] ) return a[0]-b[0]; 
            return b[1] - a[1]; 
        }); 
        int n = s.length();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '*' && !pq.isEmpty()) {
                int curr[] = pq.poll();
                // char rem = (char)curr[0]; 
                // System.out.println("Remove : " + rem);
                set.add(curr[1]);
            }
            else{
                // System.out.println(ch);
                pq.offer(new int[]{ch , i});
            }
        }

        StringBuilder str = new StringBuilder(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '*' || set.contains(i)){
                continue; 
            }
            str.append(ch);
        }

        return str.toString();
    }
}