class Solution {
    int n ; 
    Long dp[]; 
    public int getNextValue(long val , int nums[]){
        int left = 0; 
        int right = nums.length-1; 
        int ans = -1 ; 
        while(left <= right){
            int mid = left + (right - left) / 2; 

            if(nums[(int)mid] >= val){
                ans = mid; 
                right = mid-1 ; 
            }
            else {
                left = mid+1; 
            }
        }
        // System.out.println("I am in binary search and : " + ans);
        return (int)ans; 
    }
    public long f(int i , Map<Integer , Long> map , int[] power){
        if(i == n ) return 0 ; 
        long take = 0 ; 
        long skip = 0 ; 
        if(dp[i] != null ) return dp[i]; 
        skip = f(i+1 , map , power );
        take = map.get(power[i]);
        int nextVal = getNextValue(power[i] + 3 , power);
        if(nextVal != -1){
            // System.out.println(" I am taking the number : " + nextVal + " the value is " + map.get(power[i]) );
            take += f(nextVal , map , power);
        }
        return dp[i] =  Math.max(take , skip);
    }
    public long maximumTotalDamage(int[] power) {
        // each power show us damage of a spell, multpile spell could have the same damage value 
        // if is know taht if a magica decides to cast aspell with damge power[i] they cannot case any spell with damage or power[i]-2 , power[i]-1 , power[i] + 1 or poswr[i] + 2 
        // each spell cant only be cast once 
        // return the maximum spell damage 

        // We do have chooices like we could either use a spell or skip it and check for the better 
        // but we need to keep track of the previously used spell as we cant take -1 , -2 , +1 , +2 of the used spell power anuthing above or below is ok 

        // or greddy is there any greedy here 
        // [1,1,2,2,7,7,9,9]
        // can sorting and taking min wont cut it this test case disprove this 
        // [10,9,7,7,6,6,6,6,6,3,4]
        // taking the biggest case and then taking in range also does not do it


        // I just feel like this is a dp cause of the choice we have each point so but the 2 state is needed I think which would bomb the constraints 
        // I know one state is i but the only question remain is how do i keep track of the stupid taken power like i have choose this power we need it so we dont take that power+1,+2 , -1 , -2 
        // use loop inside the dp like take the avalibale value and try to find the 
        Map<Integer , Long> map = new HashMap<>(); 
        n = power.length;
        Arrays.sort(power);
        dp = new Long[n]; 
        for(int i = 0 ; i < n ; i++){
            int num = power[i]; 
            map.put(num , map.getOrDefault(num , (long)0 ) + (long)num);
            // System.out.println(num + " and its total is : " + map.get(num));
        }

        return f(0 , map , power );
    }
}