class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long sum = 0 ; 
        int rows = n; 
        int col = n ; 
        int len = queries.length; 
        Set<Integer> seenRow = new HashSet<>(); 
        Set<Integer> seenCol = new HashSet<>(); 
        for(int i = len-1 ; i>= 0 ; i--){
            int curr[] = queries[i];
            int type = curr[0]; 
            int indx = curr[1]; 
            int val = curr[2] ; 

            if(type == 0 ){
                if(col >= 0 && !seenRow.contains(indx)){
                    seenRow.add(indx);
                    sum += val * col; 
                    rows--;
                }else continue; 
            }else{
                if(rows >= 0 && !seenCol.contains(indx)){
                    seenCol.add(indx);
                    sum+= val * rows;
                    col--; 
                }else continue; 
            }
        }
        return sum ; 
    }
}