class Solution {
    
    public String processStr(String s) {
        StringBuilder str = new StringBuilder() ; 

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(str.length() >=1)
                    str.deleteCharAt(str.length()-1);
                // System.out.println("THis is the op at * " + str.toString());
            }
            else if(ch == '#'){
                str.append(str);
                // System.out.println("THis is the op at #  " + str);
            }
            else if(ch == '%'){
                str = str.reverse(); 
                // System.out.println("THis is the op at %  " + str);
            }

            else{
                str.append(ch);
                // System.out.println("THis is the op at else " + str);
            }
        }

        return str.toString();
    }
}