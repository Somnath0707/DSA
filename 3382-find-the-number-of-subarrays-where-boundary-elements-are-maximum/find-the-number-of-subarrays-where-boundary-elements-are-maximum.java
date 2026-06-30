class Solution {
    public long numberOfSubarrays(int[] nums) {
        Stack<Integer> st = new Stack(); 
        long ans = 0 ; 
        int n = nums.length ; 
        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            if(st.isEmpty() || st.peek() >= val){
                st.push(val);
            }

            else{
                long streak = 0 ; 
                int prev = 0 ; 
                while( !st.isEmpty() && st.peek() < val ){
                    if(prev != st.peek()){
                        streak = 1; 
                    }
                    if(prev == st.peek()){
                        streak++; 
                    }
                    ans += streak;
                    prev = st.pop();
                    
                }
                st.push(val);
            }
        }
        int prev = 0 ;
        long streak = 0 ;  
        while(!st.isEmpty()){
            
            if(prev != st.peek()){
                streak = 1 ; 
            }
            else if(prev == st.peek()){
                streak++; 
            }
            ans += streak;
            prev = st.pop();
            
        }

        return ans; 
    }
}