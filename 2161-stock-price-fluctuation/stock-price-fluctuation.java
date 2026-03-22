class StockPrice {
    TreeMap<Integer, Integer> map;   // price -> freq
    TreeMap<Integer, Integer> time;  // timestamp -> price

    public StockPrice() {
        map = new TreeMap<>();
        time = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {

        // ✅ only remove if timestamp already exists
        if (time.containsKey(timestamp)) {
            int oldPrice = time.get(timestamp);

            map.put(oldPrice, map.get(oldPrice) - 1);
            if (map.get(oldPrice) == 0) {
                map.remove(oldPrice);
            }
        }

        // update new price
        time.put(timestamp, price);
        map.put(price, map.getOrDefault(price, 0) + 1);
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