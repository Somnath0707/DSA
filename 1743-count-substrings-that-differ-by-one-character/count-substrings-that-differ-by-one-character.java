class Solution {
    public boolean check(String str , String str2){
        int count = 0 ; 
        // System.out.println(str);
        // System.out.println(str2);
        for(int i = 0 ; i < str.length() ; i++){
            char ch1 = str.charAt(i);
            char ch2 = str2.charAt(i); 

            if(ch1 != ch2) count++; 
            // if(count > 1) return false; 
        }
        if(count == 0) return false; 
        if(count > 1 ) return false; 
        return true;
    }
    public int countSubstrings(String s, String t) {
        int count = 0; 
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                String str = s.substring(i , j+1 ); 

                int len = str.length(); 
                int left = 0 ; 
                for(int k = 0 ; k <= t.length()-len ; k++){
                    String str2 = t.substring(k , k+len); 
                    if(check(str , str2)) count++; 
                }
            }
        }
        return count; 
    }
}