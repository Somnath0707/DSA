class Solution {

    Map<String , Integer> map ; 
    public long f(int i , long nume , long deno ,  long k , int nums[]){
        if(i == nums.length){
            if(nume == k * deno) return 1; 
            return 0 ; 
        }
        String key = i + "#" + nume + "#" + deno ; 

        if(map.containsKey(key)) return map.get(key);

        long mul = f(i+1 , nume * nums[i] , deno  ,k , nums );


        long div = f(i+1 ,nume , deno * nums[i] , k , nums);

        long aura = f(i+1 , nume , deno , k , nums);

        long ans =  mul + div + aura; 
        map.put(key , (int)ans );
        return ans; 


    }
    public int countSequences(int[] nums, long k) {
        // What do we have here 
        // nums array and int k 

        // start with an intital val = 1 and process nums from left to right at each index you must choose exactly one of the following actions 
        // mul val by nums[i]; 
        // divide val by nums[i] ; 
        // leave val unchange 

        // after processing all elem val is considered eql to k only if its final rational value exact equals k 
        // return the count of distinct seq of choices that result in val == k 

        // div is rational not int examp 2 / 4 = 1/2 
        map = new HashMap<>();

        return (int)f(0 , 1 , 1 , k , nums);
    }
}