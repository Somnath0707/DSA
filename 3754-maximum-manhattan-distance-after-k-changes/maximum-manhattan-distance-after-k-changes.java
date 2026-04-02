class Solution {
    public int maxDistance(String s, int k) {
        char[][] directions = {
            {'N' , 'E'},
            {'N' , 'W'},
            {'S' , 'E'},
            {'S' , 'W'}
        };
        int max = 0 ; 

        for(char d[] : directions){
            int count = 0 ; 
            
            int tempK = k ; 

            for(char ch : s.toCharArray()){
                if(ch == d[0] || ch== d[1]){
                    count ++ ; 
                }
                else if(tempK > 0 ){
                    count ++ ; 
                    tempK--; 
                }
                else {
                    count -- ; 
                }
                max = Math.max(count , max);
            }
        }
        return max ; 
    }
}