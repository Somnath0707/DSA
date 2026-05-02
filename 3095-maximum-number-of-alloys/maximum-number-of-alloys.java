class Solution {

    public boolean getAns(int count , int budget , List<Integer> temp , List<Integer> stock , List<Integer> cost){
        // put the total count in the compostion 
        long currBudget = 0;
        for(int i = 0 ; i < temp.size() ; i++){
            // the mid number of count or try mid number and sub the stock we have 
            long needed =(long)temp.get(i) * count - stock.get(i);
            if(needed < 0 ) continue;
            currBudget += needed * cost.get(i);
            if(currBudget > budget){
                return false;
            }
        }
        return true; 
    }

    public int bs(int budget , List<Integer> temp , List<Integer> stock , List<Integer> cost ){
        int low = 0 ; 
        int high = 1000000000;

        int ans = 0 ; 

        while(low <= high ){
            int mid = low + (high - low ) / 2 ; 

            if(getAns(mid , budget , temp , stock ,cost)){
                ans = mid ;
                low = mid + 1 ; 
            }else {
                high = mid - 1 ; 
            }
        }
        return ans;
    }
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        // Sort the composition take the one with minimum composition
        // Do we use binary search on ht number of the alloys we can make 
        // As the constrains are very small 100 but the budget is 10^8 it only make sense to check wheter the current number of alloys could be made using this and try fo all the compostion and take the maximum 

        // tkae the composition and stock and alloy count 1 - 1e8 for example and 
        // try for each get the max we could get in that compostion and then go for the next 
        int total = -1; 

        for(int i = 0 ; i < composition.size() ;i++){
            List<Integer> temp = composition.get(i);
            int currMax = bs(budget , temp , stock , cost);
            total = Math.max(currMax , total);
        }

        return total ;
    }
}