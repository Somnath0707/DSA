class Solution {
    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public int wordCount(String[] startWords, String[] targetWords) {
        // if lenDiff > 1 not possible 
        // if len same then too not possible 
        // even if one word is diff not possible 
        // if start word len is greater then too not possible 

        // if i use treemap 
        Map<String,Integer> map = new HashMap<>();
        int n = startWords.length; 
        int m = targetWords.length; 
        for(int i = 0 ; i < n ; i++){
            String val = sort(startWords[i]); 

            map.put(val , map.getOrDefault(val , 0) + 1 );
        }
        int count = 0 ; 
        for(int i = 0 ; i < m ; i++){
            
            String val = targetWords[i]; 
            for(int j = 0 ; j < val.length() ; j++){
                StringBuilder str = new StringBuilder(); 
                for(int k = 0 ; k < val.length() ; k++){
                    char ch = val.charAt(k); 
                    if(k == j)continue; 
                    str.append(ch); 
                }
                if(map.containsKey(sort(str.toString()))) {
                    count++;
                    break;
                }
            }
        }
        return count; 
    }
}