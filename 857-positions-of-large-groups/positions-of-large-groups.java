class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Character> list = new ArrayList<>();

        for(char c : s.toCharArray()){
            list.add(c);
        }

        int count = 1; 
        for(int i =0 ; i < s.length() - 1; i++){
            if(list.get(i) == list.get(i+1)){
                count ++;
            }
            else if(list.get(i) != list.get(i+1) && count >=3 ){
                List<Integer> start = new ArrayList<>();
                start.add(i-count+1);
                start.add(i);
                ans.add(start);
                count = 1; 
            }
            else count = 1; 
        }

        if(count >= 3){
            List<Integer> start = new ArrayList<>();
            start.add(s.length() - count);
            start.add(s.length() - 1);
            ans.add(start);
        }

        return ans; 
    }
}