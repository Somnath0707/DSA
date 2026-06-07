class Solution {
    Integer dp[][]; 
    public int f(int i , int limit ,  int prices[]){
        if(i == prices.length){
            return -0; 
        }

        if(dp[i][limit] != null) return dp[i][limit]; 
        int take = Integer.MAX_VALUE ; 
        int skip = Integer.MAX_VALUE ; 

        
        // System.out.print("taken :  " + prices[i] + " at index : " + i + " so skip can be " + limit + i + 1 + " ");
        take = prices[i] + f(i+1 , Math.max(limit, 2 * i + 1), prices);
        // System.out.println();
        // System.out.println("take is: " + take);

        if(i <= limit && i != 0 ){
            // System.out.print("Can Skip : " + prices[i] + " ");
            skip = f(i+1 , limit  , prices);
        }

        

        return dp[i][limit] = Math.min(take , skip );
    }
    public int minimumCoins(int[] prices) {
        // price[i] tell the no of coins to purchasse the i+1 fruit

        // market has a reward system : 
        // if we buy the i+1 fruit at prices[i] we can get any number of the net i fruits for free 

        // even tho we can take fruit j for free we can still purcahse it for prices[j-1] coins to receive the reward 
        int n = prices.length ; 
        // return theminimum no of coins to acquire all the fruits 
        dp = new Integer[n][n*10];
        return f(0 , 0 ,  prices);
    }
}

// 14 + 37 + 15  =29 + 37 =66
// 14 37 12 = 51 + 12 = 63 