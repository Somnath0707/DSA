class Solution {
    public void f(String s , int i , List<List<String >> ans , List<String> path  ){
        if( i >= s.length()) {
            ans.add(new ArrayList<>(path));
            return ;
        }

        for(int k = i ; k < s.length(); k++){
            if(isPalindrome(s.substring(i , k+1 ))){
                path.add(s.substring(i,k+1));
                f(s , k+1 , ans , path );
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String >> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        f(s ,0 , ans , path);
        return ans;
    }

    public boolean isPalindrome(String s){
        StringBuilder str = new StringBuilder(s);
        if(s.equals(str.reverse().toString())){
            return true; 
        }
        return false;
    }
}