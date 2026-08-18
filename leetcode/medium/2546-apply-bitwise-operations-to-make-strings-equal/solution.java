class Solution {
    public boolean makeStringsEqual(String s, String target) {
        int countZero = 0 ; 
        int count = 0 ; 
        int n = s.length(); 
        for(int i = 0 ; i < n ;i++){
            char ch = s.charAt(i); 
            char ch2 = target.charAt(i); 

            if(ch == '0') countZero++ ; 
            if(ch2 =='0') count++; 
        }

        if(countZero == n || count == n ){
            if(countZero == count) return true; 
            return false; 
        }

        return true; 
    }
}