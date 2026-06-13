class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for(String word : words){
            int sum =0 ; 

            for(char w : word.toCharArray()){
                sum+=weights[w -'a'];
            }
            int mod = sum% 26;

            char map = (char)( 'z' - mod);

            result.append(map);
        }

        return result.toString();

        
        
    }
}