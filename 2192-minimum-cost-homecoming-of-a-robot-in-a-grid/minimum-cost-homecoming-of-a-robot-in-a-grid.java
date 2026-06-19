class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int n = rowCosts.length; 
        int m = colCosts.length;

        int row = startPos[0]; 
        int col = startPos[1]; 
        int eRow = homePos[0]; 
        int eCol = homePos[1];
        int ans = 0; 
        if(row < eRow){
            for(int i = row+1 ; i <=eRow ; i++){
                ans += rowCosts[i];
            }
        }
        else if(eRow < row){
            for(int i = row-1 ; i >= eRow ; i--){
                ans += rowCosts[i]; 
            }
        }

        if(eCol > col){
            for(int i = col+1 ; i <= eCol ; i++){
                ans += colCosts[i];
            }
        }
        else if(col > eCol){
            for(int i = col-1 ; i>= eCol ; i--){
                ans+= colCosts[i];
            }
        }

        return ans;
    }
}