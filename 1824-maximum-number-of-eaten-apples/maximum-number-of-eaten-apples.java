class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // apple grows every day for n days 
        // ith day apple[i] number of apple grows 
        // the apple on ith day rot after i + days[i] days
        // some day tree may not grow any apple 
        // we can eat only one apple per day 
        // we can keep eating after n days too 
        // return max apple we can eat 

        // take the apple and put the expiry day on them eat the once that are gonna expire early 
        // reduce there quntatiy first 
        // so after the apples are expired we remove them from the ds 

        // after very passing day we reduce the days in the current expiry date apple 
        // we remove the apple from the list or the data struture either of condition 
        // 1 : if the apple we were eating till the expirty are over 
        // 2 : we reach the expiry date of the apples which can be either 0 if we reduce the days from the data strucutre of we reach 0 or we reomove form the ds when the days become more the expiry date ok 

        // example : apples = [1,2,3,5,2], days = [3,2,1,4,2]

        // on day one we had one we eat that so no need of any futher stuff 

        // on 2nd day 2 apple came we eat one of them and one with the expiry date (1 , 1+2 = 3) as per the formula of i+ days[i];so the apple will rot after 3rd day 

        // on 3rd day we got 3 apple but we also had the apple form before which were gonna expire today so we eat that one so 0 , 3 remove that but we now have 3 , 2+1 = 3 the apple on 3rd day rot toady so we remove that too so we dont have any apple today 

        // on 4 the day we have 0 apple we got 5 we eat one of them we how have 4 , 4+7
        // we 4 apple that will rot on 7 day 
        // on 5 th day we have 2 that will rot on 7 as well so we eat any one of them 
        // so on 6 th day we have no apple tree growing but we have saved some the 4+1,7 so we eat one s0 4 , 7 
        // on day 7 we eat one and rest of them spoil today so we remove them 
        // we get teh answer as 7 as we can eat apple till 7 and after that we chill

        // now the question is what data structure which can hold the data sequentailly and remove once the days are over 
        // needs : we want data to be stored in sorted manner in ascending form of the days 
        // we should also we able to remove the the data form the specific range 
        // heap is the only one comes in my mind currently 

        // we put the apple in the heap and the days in ascending format once the days are go we pop to check if the expiry is done if so we keep on poping until we get the date where the apple are still good 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]) ;
        int count = 0 ; 
        int n = apples.length;

        for(int i = 0 ; i < n ; i++){
            // we eat if the apples is not zero 
            int todayApple = apples[i];
            int rotDay = i + days[i];
            if(todayApple > 0 ){
                pq.offer(new int[]{todayApple , rotDay});
            }
            if(!pq.isEmpty()){
                // and current is not zero ;
               
                while(!pq.isEmpty() && pq.peek()[1] <= i ){
                    pq.poll();
                }

                // eat one 
                if(!pq.isEmpty()){
                    int curr[] = pq.poll();
                    int apple = curr[0];
                    int day = curr[1];
                    apple--;
                    count++;
                    if(apple > 0)
                    pq.offer(new int[]{apple , day});
                }
            }
        }
        int ind = n;
        while(!pq.isEmpty()){
            while(!pq.isEmpty() && pq.peek()[1] <= ind ){
                pq.poll();
            }

                // eat one 
            if(!pq.isEmpty()){
                int curr[] = pq.poll();
                int apple = curr[0];
                int day = curr[1];
                apple--;
                count++;
                if(apple > 0)
                pq.offer(new int[]{apple , day});
            }
            ind++;
        }
    return count; 
    }
}