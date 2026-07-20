class Solution {
    public int[][] copy(int [][]grid , int temp[][]){
        int n = grid.length ; 
        for(int i = 0 ; i < n ; i++){
            temp[i] = grid[i].clone(); 
        }
        return temp; 
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int l) {
        int n = grid.length; 
        int m = grid[0].length; 
        int[][] temp = new int[n][m]; 

        for(int i = 0 ; i < l ; i++){
            temp = copy(grid, temp); 
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < m ; k++){
                    if(j < n-1 && k == m-1){
                        grid[j+1][0] = temp[j][k];
                    }else if(j == n-1 && k == m-1){
                        grid[0][0] = temp[j][k]; 
                    }else{
                        grid[j][k+1] = temp[j][k]; 
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>(); 
        for(int num[] : grid){
            List<Integer> tempList = new ArrayList<>(); 
            for(int i = 0 ; i < num.length ; i++){
                tempList.add(num[i]);
            }
            list.add(tempList);
        }
        return list; 
    }
}