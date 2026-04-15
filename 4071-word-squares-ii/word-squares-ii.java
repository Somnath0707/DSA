class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0 ; i < words.length ; i++){
            for(int j = 0 ; j < words.length ; j++){
                if(i == j ) continue; 
                for(int k = 0 ; k < words.length ; k++){
                    if(i == k || j == k ) continue;
                    for(int l = 0 ; l < words.length ; l++){
                        if(l == j || l == k || i == l) continue;

                        String top = words[i];
                        String left= words[j];
                        String right = words[k];
                        String bottom = words[l];


                        if(top.charAt(0) == left.charAt(0) &&
                           top.charAt(3) == right.charAt(0) &&
                           bottom.charAt(0) == left.charAt(3) &&
                           bottom.charAt(3) == right.charAt(3)){
                            ans.add(Arrays.asList(top , left , right , bottom));
                        }
                    }
                }
            }
        }
        ans.sort((a,b) -> a.toString().compareTo(b.toString()));
        return ans ;
    }
}