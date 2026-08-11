class Solution {
    public boolean checkArray(int[] nums, int k) {
        // if max number is greater than k we cant make the answer 
        // if we have zero then we can take subarray as the reduction does not apply on zero 
        // 1 0 1 k =1  is true this proves it 
        // return false; 
        // lol i misunderstood the question the question is we can take subarray of string k 
        // so we cant take the zeros in the subarray welp thats bad now

        // we can take subarray of size k only and then reduce it to the min of that subarray lol if min is 0 we cant 

        // 1 1 0 1 1 1 0 
        // 1 2 2 3 4 5 5 

        // this is it  we get the prefix sum of these and then we get sub string of size if the substring has 
        // if we cant make the substring of size k then return false 
        // if we can now check for the next if it is ppsible to make the substring that is we can do is us bs to get next where there is dups or simply use a treemap or something which tells the next dups from curent index so see if the curr next - curr is >= k if not nah this wont work 



        // nah this aint working 
        // 2 3 2 1 0 0 
        // 2 5 7 8 9 0 
        //if max is in the middle of the window we cant do shit 
        // else we take the min in the 
        // we can do is like get array diff array perfrom all the opertaon 
        // like take window and go on take min and do the difference arary in the nums move the window till the end if at the end all the nums in the diff array is 0 return true return false; 

        // ex  1 3 1 1 k = 2 
        // 1 3 min is 1 so 0 2 1 1 
        // next 2 1 min is 1  so 0 1 0 1 
        //  next 0 1 min is 0 so 0 1 0 1 
        //next out of the window cant do check not all are 0 so return false; 

        // 2 2 3 1 1 0  k = 3 
        // 2 2 3 min is 2 so 0 0 1 1 1 0 
        // next 0 1 1 1 min is 0 so 0 0 1 1 1 0 
        // next is 1 1 1 min is 1 so 0 0 0 0 0 
        // next  all 0 at end answer is all zero lmao we got the answer true; 

        // // 2 3 2 1 0 0  k = 2 
        // 2 3 min = 2 so 2 2 0 0 0 0
        //  newMin = 3 -2 or  2 new min is 1 so 2 3 1 0 0 0 
        // newMin = 2-1 or 1  new min is 1 so 2 3 2 1 0 0 

        // we need running min 
        // 2 2 3 1 1 0 
        // 2 2 3 running min is 2 second is 2   so 2 2 2 0 0 0 
        // new min = 2- 2 = 0 is 0 so 2 2 2 0 0 0 
        // next 3 1 1 we removed is 2  min = 3-2 or 1 which is 1 so 2 2 2 3 1 1 

        // how do we carray the running min now 
        // return false; 

        // so we need diff array to keep the track of the reduction and we need queue where we put the minimum  and after each k steps remove the first and reduce from the total continus running sum 

        Queue<Integer> q = new LinkedList<>(); 

        int runningSum = 0 ; 
        int n = nums.length ; 
        int runK = 0 ;
        for(int j = 0 ; j < n ; j++){
            if(q.size() == k)
            runningSum -= q.poll(); 

            int curr = nums[j] - runningSum; 
            if(curr < 0 ) return false; 
            // if(curr == 0 ){
            //     runK++; 
            //     continue; 
            // }

            if(curr > 0){
                if(j+k > n) return false; 
                runningSum += curr; 
                q.offer(curr); 
            }
            else{
                q.offer(0); 
            }
        }



        return true; 
    }
}