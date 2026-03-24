class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int i = horizontalCut.length -1 ; 
        int j = verticalCut.length - 1 ; 

        long vPieces = 1 ,  hPieces = 1 ; 
        long cost = 0 ; 

        while(i >= 0 && j >= 0 ){
            if(horizontalCut[i] > verticalCut[j]){
                cost += horizontalCut[i] * vPieces;
                hPieces++;
                i--;
            }else{
                cost += verticalCut[j] * hPieces;
                vPieces ++;
                j--;
            }
        }


        while(i >= 0 ){
            cost += horizontalCut[i] * vPieces;
            i--;
        }
        while(j >= 0 ) {
            cost += verticalCut[j] * hPieces;
            j--;
        }

        return (int)cost ;
    }
}