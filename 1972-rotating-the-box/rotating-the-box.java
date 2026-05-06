class Solution {
    public char[][] rotateTheBox(char[][] nums) {
        int n = nums.length ; 
        int m = nums[0].length ;
        for(int i = 0 ; i < n ; i++){
            int start = -1 ; 
            for(int j = 0 ; j < m ; j++){
                char ch = nums[i][j];
                if(ch == '*'){
                    start = -1;
                }
                if(ch == '.' && start != -1 ){
                    nums[i][start] = '.';
                    nums[i][j] = '#';
                    start++;
                }
                if(ch == '#' && start == -1 ){
                    start = j;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }

        char ans[][] = new char[m][n];
        int ind = 0 ; 
        for(int i = n-1 ; i >= 0 ; i-- ){
            for(int j = 0 ; j < m ; j++){
                ans[j][ind] = nums[i][j];
            }
            ind++;
        }
    return ans;
    }
}