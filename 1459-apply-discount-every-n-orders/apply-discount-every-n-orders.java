class Cashier {
    // To keep the track of the customer
    int count ;
    // Map to store the products_Id  along with there prices
    Map<Integer , Integer> map ; 
    // Discount 
    int dis ; 
    // Condition to give the discount 
    int discount_Condition; 

    public Cashier(int n, int discount, int[] products, int[] prices) {
        // Initillly 0 count 
        count = 0 ; 
        // Intitilize the values
        this.dis = discount; 

        map = new HashMap<>();
        this.discount_Condition = n ;

        // put the productId and prices in the map 

        for(int i =0 ; i< products.length ; i++){
            map.put(products[i] , prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        // count ++ as the new customer 
        count ++;
        // bill
        double bill =0; 

        for(int i =0 ; i < product.length ; i++){
            // bill will be the price of the product and the amount we buy 
            bill += map.get(product[i]) * amount[i];
        }
        if(count == discount_Condition){
            count = 0; 
            return (bill - (dis * bill) / 100);
        }
        else return bill; 
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */