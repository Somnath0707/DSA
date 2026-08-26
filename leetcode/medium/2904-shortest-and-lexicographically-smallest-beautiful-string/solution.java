class Solution {
    public boolean check(String str, int j, int ind, String s) {
        String temp = s.substring(j, ind + 1);
        for (int i = 0; i < temp.length(); i++) {
            if (str.charAt(i) == '1' && temp.charAt(i) == '0') {
                return true;
            } else if (str.charAt(i) == '0' && temp.charAt(i) == '1')
                return false;
        }
        return true;
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int j = 0 ; 
        int n = s.length(); 
        String str = "";
        int bestCount = Integer.MAX_VALUE ; 
        int count = 0 ; 
        int len = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '1') count++; 
            len++; 
            while(count > k || (count == k && s.charAt(j) == '0')) {
                if(s.charAt(j) == '1') count--; 
                j++; 
                len--; 
            }
            if(count == k && len == bestCount){
                if(check(str , j , i , s)){
                    str = s.substring(j , i+1) ;
                }
            }
            
            else if(count == k && len < bestCount){
                str = s.substring(j , i+1);
                bestCount = len; 
            }
            
        }

        return str; 
    }
}