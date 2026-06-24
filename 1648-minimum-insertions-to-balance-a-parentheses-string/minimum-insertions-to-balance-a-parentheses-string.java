class Solution {
    public int minInsertions(String s) {
        int ans = 0; 
        int countOpen = 0 ; 
        int countClose = 0 ; 

        for(int i =0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            // 
            if(countOpen == 0 && ch == ')'){
                countOpen++; 
                countClose++; 
                ans++; 
            }

            else if(countOpen >= 1 && countClose == 1 && ch == '('){
                countOpen--; 
                countClose = 0 ; 
                ans++; 
                countOpen++; 
            }

            else if(countOpen >= 1 && countClose == 1 && ch == ')'){
                countOpen--; 
                countClose = 0 ; 
            }

            else {
                if(ch == '(') countOpen++; 
                if(ch == ')') countClose++ ; 
            }

        }

        // System.out.println(ans);
        // System.out.println(countClose + " " + countOpen);

        if(countOpen != 0){
            ans += countOpen * 2 - countClose; 
            return ans; 
        }
        if(countClose != 0 ){
            if(countClose % 2 != 0){
                ans += (countClose + 1) / 2;
            }
        }

        return ans; 
    }
}