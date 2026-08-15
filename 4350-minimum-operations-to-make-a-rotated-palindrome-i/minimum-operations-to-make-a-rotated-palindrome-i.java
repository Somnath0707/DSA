class Solution {
    public int check(int ind , String s){
        int i = ind; 
        int n = s.length();
        int j =(n+i-1)%n ; 
        int diff = 0 ; 
        int count = 0 ; 
        while(count < n/2){
            int currDiff =( s.charAt(i) - s.charAt(j) + 26) % 26;
            int currDiffB = (s.charAt(j)-s.charAt(i) + 26) % 26;

            int temp = Math.min(currDiff , currDiffB); 
            i = (i+1) % n ; 
            j = (j-1+n) % n ; 
            diff += temp ; 
            count++; 
        }

        return diff; 
    }
    public int minOperations(String s) {
        // we can rotate and increament no decrease so for a to beocome c we need 2 moves but to b to become c we need many more 

        // try every roatation and try every value which is i guess n^2 
        // start from the a bc which will give me see how much then try bca cab 

        // or find which of the two are closer 

        // abc can become bca cab but never acb 
        // 1 2 3-> 2 3 2 
        // 1 2 4 7 2 -> 2 4 7 2 1 -> 4 7 2 1 2 is that do any thing it will take same number of operation 

        // 1 2 3 4 -> 2 3 

        // 

        // try every left and do the minimum like we discussed  
        int i = 0 ; 
        int n = s.length(); 
        int ans = Integer.MAX_VALUE ; 
        while(i < n ){
            int temp = check(i , s); 
            ans = Math.min(i+temp , ans);
            i++; 
        }
        return ans; 
    }
}