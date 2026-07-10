class Solution {
    public int minSwaps(String s) {
        // "]]][[[" -> 
        // [] [ ] [ ]

        //  

        int closed = 0 ; 
        int open = 0 ; 
        int ans = 0 ; 

        // Stack<Character> st = new Stack<>();
        int isOpen = 0; 
        int isClose = 0; 
        int n = s.length(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(isOpen == isClose && ch == ']'){
                open++; 
                isOpen++; 
                ans++; 
            }
            else if(isOpen >= n/2 && ch == '[' && open > 0){
                open--; 
            }
            else {
                if(ch =='[') isOpen++; 
                else isClose ++; 
            }

        }
        return ans; 
    }
}