class Solution {
    int MOD = 1000000007; 
    public int numberOfGoodPartitions(int[] nums) {
        // we have to partation so is it partation dp if it is we have to check a number that occur now should not be there in any previous substring 

        // the partation stuff is childs play only thing we have too see is how do we avoid dups first thing comes to my mid is using hash map actually two hashmap one for storing the all the substrings taken elemens and one for storing the current 
        // so if we take number in curr put in curr and final if the number is in curr sub string and final that means we have this in only this partation but we have the number just in the final that means that have taken already so we would have to stop there and try other prattion but the map is changing and storing map is not wise decision so we cant do this what the next best possible move 

        // lets access what we actually need :  we need some thing that tells if the curr values has been taken previously or not and we want it as fast as possible 
        // what the option for now i can think of is map only 

        // i dont think any of it as of now is it even dp question what 

        // so we can do is find the last place where there are dups that all is one sub string and rest of the elements are the individual substrings i dont know how could this be wrong 

        // if no dups found then all are single elements 

        // if there are all dups then answer is one so its just math ish question 

        // but more impornt is what maths do we need suppose there are 3 seperate elements how many total we could make : 
        // return 6;
        // ok  i kinda get the maths too for each there would 1 +  n + n-2  + n-3

        // if % 2 += ans else += n-1 if% 3 += n

        // its maths is preety hard to figure out like how does it scale 

        // 1 2 3 4 5 6  like take 3 but how many combination with the rest of the 3 

        // dman crazy 

        Map<Integer,Integer> map = new HashMap<>(); 
        int last = -1 ; 
        int n = nums.length ; 
        // this map stores the last occ only 
        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            map.put(val , i); 
        }
        int window = 0 ; 
        int next = -1; 
        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            if(map.get(val) == i){
                if(i > next){
                    window++; 
                }
            }
            else{
                if(i > next ) window ++ ; 
                next = Math.max(next , map.get(val));
                
            }
        }
        int total = window; 
        // if(last == n-1) return 1 ; 
        // if(last == -1) total = n ; 
        // // 3-2 = 1 ; 
        // else total = n - last; 
        // System.out.println(total); 
        long ans = 1 ; 

        for(int i = 0 ; i < total-1 ; i++){
            ans = (1L * ans *2) % MOD;
        }
        return (int)ans; 
    }
}

// 2 3 3 4 8 5 6 8 

// curr = 1 window and window size is 1 to 2 next 
// 3 yesh its in windo next 4 is in window max window size was 2 and curr = 3 so no it has next no so window = 3 next = 8 so window = 4 and size is 4 to 7  next is 5 no 6 no last 8 so no 