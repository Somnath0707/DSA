class Solution {
    Map<String , Integer> dp; 
    public int f(int i , int val ,  int nums[]){
        int n = nums.length; 
        if( i == n) return 0 ; 

        String key = i + "#" + val; 

        if(dp.containsKey(key)) return dp.get(key); 

        int take = 0 ; 

        if(nums[i] < 0){
            take = Math.max(nums[i] * val + f(i+1 , val+1 , nums) , f(i+1 , val , nums));
        }
        else {
            take = Math.max(take , nums[i] * val + f(i+1 , val+1 , nums));  
        }

        dp.put(key , take );
        return take ;
    }
    public int maxSatisfaction(int[] nums) {
      // a chef has collected date on the satisfaction leve of his n dish chef can cook any dish in 1   
      Arrays.sort(nums); 
      dp = new HashMap<>(); 
      return f(0 , 1, nums);
    }
}

// In some other timeline all the hards are this level and the problem over 1700 rating never existed and I wish I was born in that universe 