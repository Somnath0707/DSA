class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = rows ; 
        int m = encodedText.length() / n;
        char [][] temp =  new char[n][m];
        int indx = 0 ; 

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                char ch = encodedText.charAt(indx++);
                temp[i][j] = ch;
            }
        }

        StringBuilder str = new StringBuilder();

        // column 
        for(int j = 0 ; j < m ; j++){
            // row
            int nextJ = j;
            for(int i = 0 ; i < n ; i++){
                str.append(temp[i][nextJ]);
                if(nextJ == m-1) break;
                nextJ++;
            }
        }

        return str.toString().stripTrailing();
    }
}