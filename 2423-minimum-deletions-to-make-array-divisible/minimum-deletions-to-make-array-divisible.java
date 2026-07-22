class Solution {
    int gcd(int a , int b){
        while(b != 0){
            int temp = b; 
            b = a % b ; 
            a = temp; 
        }
        return a; 
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int g = numsDivide[0]; 
        int n = nums.length; 

        for(int num : numsDivide){
            g = gcd(num , g); 
        }

        Set<Integer> set = new HashSet<>(); 
        for(int i = 1 ; i * i <= g ; i++){
            if(g % i == 0){
                set.add(i);

                if(i != g/i){
                    set.add(g/i); 
                }
            }
        }


        Arrays.sort(nums);

        int ans = 0 ; 
        for(int i = 0 ; i < n ; i++) {
            if(set.contains(nums[i])){
                break ;
            }
            ans++; 
        }
        if(ans == n) return -1; 
        return ans; 
    }
}