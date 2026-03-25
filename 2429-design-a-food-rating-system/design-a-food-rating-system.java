class FoodRatings {
    //  food  , cusine 
    Map<String , String> foodToCusine; 
    // food        rating
    Map<String , Integer> foodToRating;
    //  Cusine.      food
    Map<String , TreeSet<String>> map ;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCusine = new HashMap<>();
        foodToRating = new HashMap<>();
        map = new HashMap<>();
        for(int i = 0 ; i < foods.length ; i++){
            foodToCusine.put(foods[i] , cuisines[i]);
            foodToRating.put(foods[i] , ratings[i]);

            map.putIfAbsent(cuisines[i] , new TreeSet<>((a,b) ->{
                 int r1 = foodToRating.get(a);
                 int r2 = foodToRating.get(b);

                if(r1 != r2) return r2-r1;
                return a.compareTo(b);
                }    
            ));

            map.get(cuisines[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cusine = foodToCusine.get(food);

        // remove the previous rating 
        map.get(cusine).remove(food);

        foodToRating.put(food , newRating);

        map.get(cusine).add(food);
        
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */