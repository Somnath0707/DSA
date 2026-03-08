class Solution {
    public long f(int left , int right  ,int []prefixOnes,  int enCost , int flatCost ){
        int totalLen = right - left + 1 ; 

        int ones = prefixOnes[right] - (left > 0 ? prefixOnes[left - 1] : 0);;

        long costWithOutsplit;

        if(ones == 0) return flatCost;
        else costWithOutsplit = (long)totalLen * enCost * ones;

        if(totalLen % 2 != 0) return costWithOutsplit;
        
        int mid = left + (right - left ) / 2; 
        long split = f(left , mid , prefixOnes , enCost , flatCost ) + f( mid+1 , right , prefixOnes , enCost , flatCost );

        return Math.min(split , costWithOutsplit);



    }
    public long minCost(String s, int encCost, int flatCost) {
        int [] prefixOnes = new int[s.length()];
        int oneCount = 0; 
        for(int i = 0; i < s.length() ; i++){
            char curr = s.charAt(i);
            if( curr ==  '1'){
                oneCount ++;
                prefixOnes[i] = oneCount ;
            }
            prefixOnes[i] = oneCount ;
        }


        return f(0 , s.length()-1 , prefixOnes , encCost , flatCost);
    }
}