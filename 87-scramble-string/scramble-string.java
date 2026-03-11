class Solution {
    Map<String , Boolean > memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;

        if(s1.length() != s2.length()) return false;

        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean temp = false; 
        int n = s1.length();
        

        for(int i = 1 ; i< n ; i++){

            boolean swapped = isScramble(s1.substring(0 , i  ) , s2.substring(n-i)) && 
                              isScramble(s1.substring(i) , s2.substring(0 , n-i));

            boolean notSwapped = isScramble(s1.substring(0 , i) , s2.substring( 0 , i )) &&
                                 isScramble(s1.substring(i) , s2.substring(i));

            if(swapped || notSwapped) temp = true;
        }

        memo.put(key , temp);
        return temp;
    }
}