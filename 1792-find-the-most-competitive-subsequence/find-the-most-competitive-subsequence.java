class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        // we have pos array nums and k 
        // we need ot return the competitive subsequence 

        // an arr subseq is a subseq which we get by earasing some elements from array 

        // a competitive subsequence 'a' o more comp than sub 'b' of same len ifin the firstpos where and and b differ subseq a has a number less than corrosponding b

        // ex 1 , 3 , 4 and 1 , 3 , 5 here the sub seq differ at 4 and 5 the one with lower number is more competitive so 1,3,4 is more competitive 


        // Initital thoughts 
        // we try to take the minimum number that has the range of atleast k as it should be possible to make sequence of atleast k size 
        // then after that we take the second smallest elemnt after that such that there are still element that should fit the remaining sub seq else we directly take the elements 

        // ex 3 , 5 , 2 , 6 k = 2
        // here the smallest = 2 but after that are there enought element to make the valid subsequense curr size = 1 and remain = 1 i= 2 , n = 3 so n-i = 1 so yeah there is actually one element that we can take to make valid subarray 
        // so after that we take that element 
        // answer is 2, 6

        // 2, 4 , 3 , 3 5 , 4 , 9 k = 4
        // smallest = 2 can we make the rest size = 1 remain = 3 and array remain 5 yeah
        // take take the second smalest 3 at inde 2remain = 2 and array = 4 yeah 
        // next samllest is 3 can we take it yeah 
        // next is 4 can we take it yeah 

        // but what if there is case were we cant really take the element that are smaller we take the other smaller which are in higher index ex 

        // 3,5,2,6 k = 3

        // here smaller = 2 but we cant take that cause the size will not suffice 
        // so the we need to find the smallest before the n-k+1 so from 0 to n-k+1
        // 3,5,2,6 k = 3 here n= 4 k = 3 so the range will be 0 to 4-3+1=2 so 0 to <2
        // which is 3 after that we get the element we reduce the k for the rest same 
        // suppose for the first the range was k = 3 than after one element we reduce the range to k-1 as we select one and we take the samllest in range i (selected) to the next n-k+1 we get the smallest among them so here 1 to 4-2+1 = <3
        // so we have choice of 5 or 2 we take 2 and hten we have only one option that is take 6 
        // so the answer would be 3 , 2 , 6 


        // Needs :
        // we need to check for the n+k-1 until we get k == 0 so sliding window we need to get the minimum element in each window 
        // So its sliding window then ig right ?
        // or monotonic stack ig to as in each range we can keep the track of the smallest element in that ragne 

        //take the first element till the rnage and take min start the next window from that small element 
        

        Stack<Integer> stack = new Stack<>();
        int temp = k ; 

        int n = nums.length ; 

        // put the first range element in the stack 
        for(int i = 0 ; i < n ; i++){
            int curr = nums[i];
            // if stack is emtpy we push
           
            // if curr is smaller than top 
            // but also it should be in range 
            // should not remove the element such that we not get enought elements afterwards
                while(!stack.isEmpty() &&curr < nums[stack.peek()] && stack.size() + n - i > k ){
                    stack.pop();
                }
                if (stack.size() < k) {
                    stack.push(i);
                }
            }

        int arr[] = new int[temp];
        List<Integer> list = new ArrayList<>();
        int j = temp;
        for(int i =temp-1 ; i >= 0 ; i--){
            arr[i] = nums[stack.pop()];
        }

        return arr;
    }
}