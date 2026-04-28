class Solution {

    public StringBuilder remove(int num , StringBuilder str){
        int i = str.length() - 1; 

        while(i >= 0 ){
            int n = str.charAt(i) - '0';

            if(n % 3 == num ) {
                str.deleteCharAt(i);
                break;
            }
            i--;
        }
        return str;
    }
    public String largestMultipleOfThree(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int n : nums){
            list.add(n);
        }

        Collections.sort(list);

        StringBuilder str = new StringBuilder();
        long sum = 0 ; 
        for(int i = list.size() -1 ; i >= 0 ; i--){
            str.append(list.get(i));
            sum += list.get(i);
        }
        
        if(nums.length == 1 && nums[0] != 0) return "";
        if(str.length() > 0 && str.charAt(0) == '0') return "0"; 
        if(sum % 3 == 0 ) return str.toString();

        else if(sum % 3 == 1 ) {
            int oldLen = str.length();
            str = remove( 1 , str);
            if(str.length() == oldLen){
                str = remove(2 , str);
                str = remove(2 , str);
            }
            if(str.length() > 0 && str.charAt(0) == '0') return "0"; 
            return str.toString();
        }
        else if(sum % 3 == 2 ){
            int oldLen = str.length();
            str =remove(2, str);
            if(str.length() == oldLen){
                str = remove(1 , str);
                str = remove(1 , str);
            }
            if(str.length() > 0 && str.charAt(0) == '0') return "0";
            return str.toString();
        }

        return "";
    }
}