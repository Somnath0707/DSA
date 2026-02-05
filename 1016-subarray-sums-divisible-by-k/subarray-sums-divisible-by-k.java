class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();

        int sum =0; 
        int count =0 ; 

        map.put(0 , 1); // to handle subarrays that start from the beginneing 

        for(int n: nums){
            sum += n;

            int mod = (sum % k+k)%k;

            if(map.containsKey(mod)){
                count+= map.get(mod);
                map.put(mod,map.get(mod) + 1);
            }
            else{
                map.put(mod , 1);
            }
        }
        return count ; 


    }
}