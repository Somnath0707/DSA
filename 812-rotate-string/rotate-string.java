class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false; 
        StringBuilder str = new StringBuilder(s);
        str.append(s);
        String temp = str.toString();
        if(temp.contains(goal)) return true; 
        return false;
    }
}