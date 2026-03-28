class Spreadsheet {
    Map<String , Integer> map ;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell , value);
    }
    
    public void resetCell(String cell) {
        map.put(cell , 0);
    }
    
    public int getValue(String formula) {
    int firstValue = 0; 
    int secondValue = 0;
    int count = 0; 

    // find '+'
    for(int i = 0; i < formula.length(); i++){
        if(formula.charAt(i) == '+') break;
        count++; 
    }

    // first part (skip '=')
    String sb = formula.substring(1, count);

    if(map.containsKey(sb)){
        firstValue = map.get(sb);
    } 
    else if(Character.isDigit(sb.charAt(0))){
        firstValue = Integer.parseInt(sb);
    } 
    else {
        firstValue = 0; // cell not set
    }

    // second part
    String sbc = formula.substring(count + 1);

    if(map.containsKey(sbc)){
        secondValue = map.get(sbc);
    } 
    else if(Character.isDigit(sbc.charAt(0))){
        secondValue = Integer.parseInt(sbc);
    } 
    else {
        secondValue = 0; // cell not set
    }

    return firstValue + secondValue;
}
}