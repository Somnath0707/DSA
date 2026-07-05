class Solution {
    public int check(int val){
        String str = String.valueOf(val);
        int max = 0 ; 
        int min = Integer.MAX_VALUE; 
        for(int i = 0 ; i < str.length(); i++){
            int num = str.charAt(i) -'0';
            max =Math.max(max , num);
            min = Math.min(min , num);
        }
        return max - min ; 
    }
    public int maxDigitRange(int[] nums) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>(); 
        int n = nums.length ; 
        for(int i = 0 ; i < n ;i++){
            int val = check(nums[i]);
            map.putIfAbsent(val , new ArrayList<>());
            map.get(val).add(i);
        }

        List<Integer> list = map.lastEntry().getValue();
        int ans = 0 ; 
        for(int i =0 ; i < list.size() ; i++){
            ans += nums[list.get(i)];
        }

        return ans; 
    }
}