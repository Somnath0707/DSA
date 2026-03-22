class StockPrice {
    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Integer> time;
    int removeCurr;
    public StockPrice() {
        map = new TreeMap<>();
        time = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(time.containsKey(timestamp)){
            removeCurr = time.get(timestamp);

        
            map.put(removeCurr , map.get(removeCurr)-1 );
            if(map.get(removeCurr) == 0) {
                map.remove(removeCurr);
            }
        }

        time.put(timestamp , price);
        map.put(price , map.getOrDefault(price , 0 ) + 1 ) ; 
        
    }
    
    public int current() {
        return time.get(time.lastKey());
    }
    
    public int maximum() {
       return map.lastKey();
    }
    
    public int minimum() {
        return map.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */