class Solution {
    public List<String> twoEditWords(String[] queries, String[] str) {

        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < queries.length ; i++){
            for(int j = 0 ; j < str.length ; j++){
                String check = queries[i];
                String temp = str[j];
                int count = 0 ; 
                for(int k = 0 ; k < check.length() ; k++){
                    if(check.charAt(k) != temp.charAt(k)){
                        count++;
                    }
                }
                if(count <=2){
                    list.add(check);
                    break;
                }
            }
        }

        return list ;
    }
}