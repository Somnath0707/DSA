class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1')
            return false;

        // this seems like that kind of problem that sound like dp but is like greedy under the hood

        // at each point we can move in the certain range the range is i+minJump...i+maxJump and that too in only zero so in that range 010 suppose this is the range we can either go to the first or the last zero we need to just reach the final so we maybe need to check both of them if the one does not work backtrack and try the diffrent zero this still makes it dp 
        // what could be the best local choice that we make greedy is we take the first appearing element 

        // if both in range as just 1s then we can move forward 
        // we can create two array that tells us where is the next 0 and where is the previous zero for if the next zero is out of range we can know that this is not the answer right 

        // or use bfs and put then 0 in the range in the queue if we reach the end by that path we get the answer else we try other till the queue is empty 
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        int nums[] = new int[n];
        int j = 0 ; 
        for(char ch : s.toCharArray()){
            nums[j++] = ch-'0';
        }
        int far = 0 ; 

        Set<Integer> set = new HashSet<>();
        set.add(0);

        while(!q.isEmpty()){
            int ind = q.poll();
            if(ind == n-1) return true; 

            int start = Math.max(ind + minJump , far+1);
            int end = Math.min(ind +maxJump , n-1);
            for(int i = start ; i <= end ; i++){
                if(nums[i] == 0 && !set.contains(i) ){
                    q.offer(i);
                    set.add(i);
                }
            }
            far = end;
        }

        return false; 
    }
}