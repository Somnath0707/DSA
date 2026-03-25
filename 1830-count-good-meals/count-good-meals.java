class Solution {
    public int countPairs(int[] nums) {
        // make a list for the 2^n
        int power[] = new int[22];
        power[0] = 1;
        for(int i = 1 ; i < 22 ; i++){
            power[i] = power[i-1] * 2 ; 
        }
        // 2,4,8,16,32,64,124,248,512,1024....

        // we make a map to keep 
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1 ) ; 
        }
        long count = 0 ; 

        for(int n : nums){
            map.put(n , map.getOrDefault(n , 0 ) -1 );
            if(map.get(n) == 0 ) map.remove(n);
            for(int p : power){
                int sub = p - n;
                if(map.containsKey(sub)){
                    count = (count + map.get(sub)) % 1000000007;
                }
            }
        }
        return (int)count ;
    }
}


// we [1,3,5,7,9] make the 2,4,8,16,32,64,124,248,512,1024....
// 1 ->  
// make a set to to put the sum of the highest two number or may be thetake the two largest number 
// sum them up and put the 2^ till the value is less than that value 
// sub the i = number from that and check if the value is there if so do the count of i * count of value we got from sub 
// 