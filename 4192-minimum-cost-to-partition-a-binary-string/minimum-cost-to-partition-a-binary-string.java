class Solution {
    public long f(int left , int right , int[] prefixOnes,int encCost , int flat){
        int totalLen = right - left + 1 ;   

        
        int Ones = prefixOnes[right] - (left > 0 ?  prefixOnes[left - 1] :0);

        long costWithOutSplit ;
        if(Ones == 0 ) return flat;
        else costWithOutSplit = (long) totalLen * Ones * encCost;

        if(totalLen % 2 != 0) return costWithOutSplit;
        int mid = left + (right - left ) / 2; 
        long split = f(left , mid , prefixOnes , encCost , flat ) + f(mid + 1 , right , prefixOnes , encCost , flat );

        return Math.min(split , costWithOutSplit);
    }
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int prefixOnes[] = new int [n];

        int ones = 0; 

        for(int i = 0; i< n ; i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                prefixOnes[i] = ones++;
            }
            prefixOnes[i] = ones;
        }

        return f(0 , n-1 , prefixOnes , encCost , flatCost);
    }
}