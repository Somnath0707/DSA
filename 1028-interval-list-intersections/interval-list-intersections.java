class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        

        // We have to get the numbers which are in the interval even if one 

        // We have to compare between two the first list and second list 

        // 0..1..2        5..6..7..8..9..10      
        //    1..2..3..4..5        8..9..10..12          

        // [1,2][5,5][8,10]

        List<int[]> list = new ArrayList<>();
        int i = 0, j =0 ; 
        
        while(i < firstList.length && j < secondList.length){
            // Usual overlap condition E1>=S2 && E2>=S1

            int s1 = firstList[i][0];
            int s2 = secondList[j][0];

            int e1 = firstList[i][1];
            int e2 = secondList[j][1];

            if(e1>=s2 && e2>=s1){
                list.add(new int[] {
                    Math.max(s1,s2),Math.min(e1,e2)
                });
            }
            if(e1 < e2){
                i =i +1;
            }else{
                j =j+ 1;
            }

        }

        int[][] ans = new int[list.size()][2];

            for (int k =0 ; k <list.size() ; k++){
                ans[k] = list.get(k);
            }
            return ans ; 
    }
}