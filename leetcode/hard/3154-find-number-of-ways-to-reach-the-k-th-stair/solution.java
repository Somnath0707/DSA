class Solution {
    int k ; 
    Map<String , Integer> map = new HashMap<>(); 

    public int f(int i , int prev , int jump  ){
       
        // prev = 0 is first prev = 1 is second 
        if(i-k > 1) return 0 ;
        if(i == k){
            // we can either return 1 or we can go ahead with next operation of do both 
            if(prev == 0){
                int nextInd = i + (int)Math.pow(2 , jump);
                return 1 + f(nextInd , 1 , jump+1 );
            }
            else{
                int nextInd = i+ (int)Math.pow(2 , jump);
                if(i != 0 ){
                    return 1 + f(i-1 , 0 , jump) + f(nextInd , 1 , jump+1);
                }else{
                    return 1 + f(nextInd , 1 , jump+1 );
                }
                
            }
        }
        String key = i + "#" + prev + "#" + jump; 

        if(map.containsKey(key)) return map.get(key); 

        int ans = 0 ; 

        if(prev == 0 ){
            int nextInd = i + (int) Math.pow(2 , jump);
            ans =  f(nextInd , 1 , jump+1 );
        }
        else{
            int nextInd = i + (int)Math.pow(2 , jump);
                if(i != 0 ){
                    ans = f(i-1 , 0 , jump) + f(nextInd , 1 , jump+1);
                }else{
                    ans = f(nextInd , 1 , jump+1 );
                }
                
            }
        map.put(key , ans); 
        return ans; 
    }
    public int waysToReachStair(int k) {
        // What could be the base case ? or the stopping case 

        // base case could be our i becoming greater than the constarint max itself 
        // or may be we cant actually after ceratin point of time go back so much doing -1 as as the jump would become so big and and also we cant do i-1 again and again 

        // if diff is > 1 then we actually and curr move is not -1 then we cant actually reach the number ahead we can go but if we cross k 

        // 4 6 = 5 + 2^jump +1 so minimum it will give 1 and max it can go out of hand 

        // so we can do is if(k - i > 1) break; 
        this.k = k; 
        map = new HashMap<>(); 
        return f(1 , 1, 0); 
    }
}