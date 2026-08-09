class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices); 
        Arrays.sort(discounts); 
        int n = prices.length; 
        int ind = discounts.length-1; 
        Double ans = 0.0; 
        for(int i = n-1 ; i>= 0 ; i--){
            if(ind < 0 ){
                ans += prices[i]; 
                continue;
            }
            ans += (double)prices[i] * (double)(100-discounts[ind])/100 ; 
            ind--; 
        }

        return ans ;
    }
}