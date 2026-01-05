/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1 , 
            right = n ; 


// If future me couldnt solve this on my own give up gng dsa is not for you boi fck off
        while (left <= right ){
            int mid = left + (right - left ) / 2;
            int guessRes = guess(mid);

            if(guessRes == 0){
                return mid;
            }else if (guessRes == -1){
                right = mid -1;
            }
            else {
                left = mid + 1; 
            }
        }
     return -1;

    }
}