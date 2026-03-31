class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {

        Map<String , String> map = new HashMap<>();

        Map<String , String> vowelSet = new HashMap<>();

        Set<String> set = new HashSet<>();

        List<String> list = new ArrayList<>();


        // Contains all the wordlist with the vowels blured so to check with the quries but other condtion does not matck 
        for(String s : wordlist){
            set.add(s);
            String res = s.toLowerCase().replaceAll("[aeiouAEIOU]", "*");
            vowelSet.putIfAbsent(res , s);
        }


        // to check the captial stuff lmao 
        for(String s : wordlist){
            map.putIfAbsent(s.toLowerCase() , s);
        }

        for(String s : queries){
            String v = s.toLowerCase().replaceAll("[aeiouAEIOU]", "*");
            if(set.contains(s)){
                list.add(s);
            }
            else if(map.containsKey(s.toLowerCase())){
                list.add(map.get(s.toLowerCase()));
            }
            else if(vowelSet.containsKey(v)){
                list.add(vowelSet.get(v));
            }
            else {
                list.add("");
            }
        }

        String[] ans = new String[list.size()];

        for(int i = 0 ; i< list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans ;
        
    }
}