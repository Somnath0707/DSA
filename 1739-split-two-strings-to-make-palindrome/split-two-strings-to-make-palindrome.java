class Solution {
    public boolean isPalindrome(String s ){
        int i = 0 ; 
        int j = s.length()-1;

        while(i <= j ){
            if(s.charAt(i) != s.charAt(j)) return false; 
            i++; 
            j--;
        }
        return true; 
    }
    public boolean checkPalindromeFormation(String a, String b) {
        if(isPalindrome(a) || isPalindrome(b)){
            return true;
        }
        int i =0; 
        int j = a.length()-1;
        while(i < a.length() && j >= 0 ){
            if(a.charAt(i) != b.charAt(j)){
                break;
            }
            i++;
            j--;
        }
        if(i >= j || isPalindrome(a.substring(i, j + 1)) || isPalindrome(b.substring(i, j + 1))) {
            return true; 
        } 

        j = 0 ; 
        i = a.length()-1;

        while(i >=0 && j < a.length()){
            if(a.charAt(i) != b.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        if(j >= i || isPalindrome(a.substring(j, i + 1)) || isPalindrome(b.substring(j, i + 1))) {
            return true;
        }
        return false; 
    }
}