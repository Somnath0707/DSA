class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length; 
        int m = boxGrid[0].length;
        char ans[][] = new char[m][n];

        int ind = 0 ; 
        for(int i = n-1 ; i >= 0 ; i--){
            int startHash = -1 ; 
            char prev = '@';
            int jInd = 0 ; 
            for(int j = 0 ; j < m ; j++){
                char ch = boxGrid[i][j];
                if(ch == '#' && startHash == -1 ){
                    startHash = j;
                    prev = '#';
                    ans[j][ind] = '#';
                }
                if(ch == '*'){
                    startHash = -1 ; 
                    prev = ch;
                    ans[j][ind] = ch;
                }
                if(ch =='.' && prev == '#'){
                    ans[startHash][ind] = '.';
                    ans[j][ind] = '#';
                    startHash++;
                    prev = '#';
                }
                else{
                    ans[j][ind] = ch;
                    prev = ch; 
                }
            }
            ind++;
        }
        return ans ; 
    }
}