class Solution {
    public String maximumBinaryString(String s) {
        // 1 1 1 0 1 0 1
        // 1 1 1 0 0 1 1
        // 1 1 1 1 0 1 1

        // 1 0 1 0 1 0 1 0 1 0 1
        // 1 0 0 0 0 0 1 1 1 1 1
        // 1 1 0 0 0 0 
        // 1 1 1 0 0 0 
        // 1 1 1 1 0 0 
        // 1 1 1 1 1 0 

        // 1s before 0 start then total 0s -1 1s one 0 and rest of the 1s ok this is the answer to any string 

        int zeroIndex = -1; 
        int countZero = 0; 
        int n = s.length(); 

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 

            if(ch == '0' && zeroIndex ==-1 ) zeroIndex = i ;
            if(ch == '0') countZero++;
 
        }
        // now we have zeros start and total zero we can get the 1s before the zero and we get 1s after the zero 

        int oneBefore = zeroIndex + countZero - 1; 
        int oneAfter = n - zeroIndex - countZero; 
        
        if(countZero == 0 ) return s;
        StringBuilder str = new StringBuilder(); 
        for(int i = 0 ; i < oneBefore ; i++){
            str.append("1");
        }
        str.append("0");

        for(int i =0 ; i < oneAfter ; i++){
            str.append("1");
        }

        return str.toString();
    }
}