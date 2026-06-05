class Solution {

    public boolean canClean(long mid , int ranks[] , int cars){
        int n = ranks.length; 
        long count = 0 ; 
        long j = 0 ;
        for(int i = 0 ; i < n ; i++){
            long sum = 0 ; 
            // long j = 0 ; 
            // while(true){
            //     sum = 1L * ranks[i] * (j*j);
            //     if(sum > mid ) break ; 
            //     j++;
            // }

            j = (long)Math.sqrt(mid / ranks[i]);

            // so tle what is the math here 
            // mid <= rank * j^2 
            // mid / rank = j^2 
            // sqrt(mid/rank ) = j 
            count += j ; 
        }

        if(count >= cars) return true; 
        return false; 
    }
    public long repairCars(int[] ranks, int cars) {
        /// We have ranks 

        // ranks[i] is the rank of the ith mechnic 
        // a mech with a rank 'r' can repair 'n' cars in r * n^2 mins 

        // We are also given int cars shoing the total cars waiting in the garage to be repaired 

        // return the minimunm time taken to repair all the cars

        // all mech can reapir cars at same time too

        // constraints are 10^5 so obv no dp 
        // no brute force 

        // we need nlogn or n solution 

        // if its not binary search on answer imma crash out lmao 

        // here it is obviuous the the one with the lowest rank should do the most amng them 

        // the one with the worst rank should do the least 

        // so do binary search for like let 4 have some 

        // lol i was thinking of binary search on the eveery number that would be stupid 

        // like first check first reparit all the 4 then go to the mid so 5 check if it repair 5 then for the rest of the 5 cars we do again binary search for the next rank person but that would be dumb asf 


        // so is it let the lowest do most of the work and the other so same amount of the work 

        // [1 , 2 , 100] cars = 4

        // so first do 2 carse and let other 2 do 2 cars = 1 * 4 + 2 * 1 + 100 * 1 = 4 + 2 + 100 = 106 

        // if if we let all the 4 crase be done by the first then cost will be 1 * 16 = 6 

        // if we spilt 2 by 2 1 * 4 + 2 * 4  = 4 + 8 = 12 
        // if first do 3 and second do only one  = 1 * 9 + 2 * 1 = 11 lmao 

        // so thise dis approve the idea that i told earlier 

        // lol i mis read we have to give the most time among them 

        // return 11; 

        // so is it really my dumb idea that sort it give the one with least the binary search and then the seond one the same bianry seach until the cost maximum cost is minimized  but this seems to be brute froce 

        // in given time how many mech could clean the car 

        long left = 0 ; 
        long right = 100000000000000L;
        long ans = 0 ; 

        while(left <= right ){
            long mid = left + (right - left) / 2; 
            /// can alll the mechanincs clean the cars in given time 
            if(canClean(mid , ranks , cars)){
                ans = mid ; 
                right = mid-1; 
            }else {
                left = mid + 1; 
            }
        }

    return ans; 
    }
}