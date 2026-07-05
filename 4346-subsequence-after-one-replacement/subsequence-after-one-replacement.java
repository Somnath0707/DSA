class Solution {
    HashSet<String> set ; 
    public boolean f(int i ,int j , int taken , String s , String t){
        if(i >= s.length()) return true; 
        if(j == t.length()){
            if(i >= s.length())return true; 
            return false; 
        }

        String key = i + "#" + j + "#" + taken;

        if(set.contains(key)) return false; 

        if ((s.length() - i) > (t.length() - j)) {
            return false;
        }
        boolean ans = false   ; 

        if(s.charAt(i) == t.charAt(j)){
            ans = f(i+1 ,j+1 , taken , s , t);
        }
        else if(s.charAt(i) != t.charAt(j)){
            if( taken == 0 ){
                ans = f(i+1 , j+1 , 1 , s , t) || f(i , j+1 , 0 , s , t);
            }else{
                ans = f(i , j+1 , taken , s , t);
            }
        }
        if(!ans) set.add(key);

        return ans; 


    }
    public boolean canMakeSubsequence(String s, String t) {
        if(s.length() > t.length()) return false ;

        // if mistmatch we have three possible ways that is either we can change the curr number use up the chance 
        // the other is if we move the i ahead and hope there is somewhere the value in the string
        // or we move j ahead in hope the thre is a vaue in j that matches the curr 

        // so for cat and chat c matchs for a and h 
        // we can either change it we can move i ahead or we can move j ahead 
        // if we chnage then i moves j also move if we just move i aheat we dont get teh value  if we move the j ahead then we get a then we can again move both i and j ahead
        set = new HashSet<>(); 
        int n = s.length(); 
        int m = t.length();
        
        return f(0 , 0 , 0 , s , t);
    }
}