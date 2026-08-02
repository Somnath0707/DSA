class Solution {
    public int reachNumber(int target) {
        // 2 ->  1 + 2 + 3 
        // first check that target is int the current series or not that series is n(n+1) /2 series if yes than its direct answre 

        // ex 0 1 3 6 10 15 21 28 36 45 55 66 78 
        // 13 -> 6-4 = 2 + 5 + 6 = 13 
        // 12 ->3-3 = 0 + 4 - 5 + 6 + 7  = 
        // 12 -> 1+2-3+4+5+6
        //  -3 -1 0 1 3 6 10 15 21 28 36 45 55 66 78 91 
        // till less than 20 
        //
        // so pattern looks like two odd two even
        long i = 0 ; 
        long sum = 0 ; 
        int steps = 0 ; 
        target = Math.abs(target);
        while(true){
            i +=1 ; 
            sum += i;
            steps++; 
            if(sum == target) return steps; 
            else if(sum > target){
                if((sum-target) % 2 == 0) return steps; 
            }
        }

    //    return steps;
        // return 6; 
        
    }
}