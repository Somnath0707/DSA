class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // put the nums in the map along with the index 

        // go through each element and then reverse it and check if the map contians this element 
        // if map contiain this element take the i - the value of from the map and do the abs sub and check answr using math min and lastly return the answer 
        //else we return -1 

        Map<Integer , Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;

        for(int i =0 ; i < nums.length ; i++){
            int num = nums[i];

            if(map.containsKey(num)){
                ans = Math.min(ans , i- map.get(num));
            }

            map.put(reverse(num) , i);

        }

        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    public int reverse(int num){
        StringBuilder sb = new StringBuilder(String.valueOf(num));

        sb.reverse();

        int reversed = Integer.parseInt(sb.toString());
        return reversed;
    }
}