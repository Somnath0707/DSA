class Solution {
    int closest ;
    public void f(int i ,   int currCost  , int nums[] , int target ){
        if(Math.abs(target - currCost) < Math.abs(target - closest) || Math.abs(target - currCost) == Math.abs(target - closest) && currCost < closest){
            closest = currCost;
        }

        // When to stop 
        if( i == nums.length) return ;


        f(i + 1 , currCost , nums , target ); // O toppings 
        f(i+1 , currCost + nums[i] , nums , target); // 1 toppings
        f(i + 1 , currCost + (2 * nums[i]) , nums , target); // 2 topings
        
    }
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // We have option to take one base 
        // we can take toping each toping could be taken 0 , 1 ,2 times 
        // we have to find the answer / price that is closest to the target price 
        // And constraints are preety small so we could get try all the possible ways 
        closest = Integer.MAX_VALUE;
        for(int base : baseCosts){
            f(0 , base , toppingCosts , target);
        }

        return closest;

    }
}