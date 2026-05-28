class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int n = searchWord.length();
        for(int i = 0 ; i < n ; i++){
            char ch = searchWord.charAt(i);
            str.append(ch);
            List<String> list = new ArrayList<>();
            for(String s : products){
                boolean isRec = true;
                // System.out.println(str.toString() + " " + s);
                if (s.length() < str.length()) continue;
                for(int j = 0 ; j < str.length(); j++){
                    char curr = s.charAt(j);
                    char prev = str.charAt(j);

                    // System.out.println(curr + "  " + prev);
                    if(curr != prev){
                        isRec = false;
                        break; 
                    }
                }
                if(isRec == true){
                    // System.out.println(s);
                    list.add(s);
                }
                if(list.size() == 3 ) break;
            }
            ans.add(list);
        }
        return ans;
    }
}