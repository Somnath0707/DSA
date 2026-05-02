class Solution {
    public int rotatedDigits(int n) {
        // 1 2 3 4 5 6 7 8 9 10
        int count = 0 ; 
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(5);
        set.add(9);
        set.add(6); 
        Set<Integer> check = new HashSet<>();
        check.add(3);
        check.add(7);
        check.add(4);
        for(int i = 0 ; i <= n ; i++){
            String str = String.valueOf(i);
            boolean rotate = false;
            boolean notPos = false;
            for(int j = 0 ; j < str.length() ; j++){
                int curr = str.charAt(j) - '0'; 
                if(set.contains(curr)){
                    rotate = true; 
                }
                if(check.contains(curr)){
                    notPos = true; 
                }
            }
            if(rotate && !notPos){
                count++;
            }
        }
        
        return count; 
    }
}