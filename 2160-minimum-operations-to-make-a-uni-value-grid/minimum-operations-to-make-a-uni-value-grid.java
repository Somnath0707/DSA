class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);

        int midEle = (0 + list.size()) / 2;
        int mid = list.get(midEle);
        // boolean even = (mid % 2 == 0 ) ? true : false; 
        int sum = 0 ; 
        for(int i = 0 ; i< list.size() ; i++ ){
            int needed = Math.abs(mid - list.get(i));
            if(needed == 0 ){
                continue;
            }
            if(needed % x != 0 ) return -1; 
            int checkSum =needed / x ; 
            sum += checkSum; 
        }
        return sum ; 
    }
}