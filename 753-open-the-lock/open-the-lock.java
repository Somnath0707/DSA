class Pair{
    String s ; 
    int num;
    Pair(String s , int num){
        this.s = s; 
        this.num = num; 
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        // create a set of visisted 
        // create a set of deadends 
        // and try all possible if the 
        // like  try +1 -1 at each position and put it in the set so for each there would be 8 possible combination 
        // we need queue which has string and the other one has steps 

        Set<String> set = new HashSet<>(); 
        Set<String> visited = new HashSet<>(); 
        int n = deadends.length;
        for(int i = 0 ; i < n ; i++){
            set.add(deadends[i]);
        }

        Set<String> setTar = new HashSet<>(); 
        setTar.add(target); 

        Queue<Pair> q = new LinkedList<>(); 

        String start = "0000";
        visited.add(start); 
        q.offer(new Pair(start , 0 ));

        if(set.contains(start)) return -1; 
        if(setTar.contains(start)) return 0 ; 

        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            String currS = curr.s; 
            int currStep = curr.num; 
            for(int j = 0 ; j < 4 ; j++){
                
                StringBuilder strFront = new StringBuilder(); 
                StringBuilder strBack = new StringBuilder(); 
                for(int i = 0 ; i < 4 ; i++){
                    char ch = currS.charAt(i); 
                    if(i != j ){
                        strFront.append(ch); 
                        strBack.append(ch); 
                        continue; 
                    }
                    char frontChar = ch; 
                    char backChar = ch ; 
                    if(ch =='0'){
                        frontChar = '1'; 
                        backChar = '9';
                    }
                    else if(ch == '9'){
                        frontChar = '0';
                        backChar = '8';
                    }
                    else{
                        frontChar = (char)(ch+1); 
                        backChar = (char)(ch-1); 
                    }
                    strFront.append(frontChar); 
                    strBack.append(backChar); 
                }
                if(setTar.contains(strFront.toString())) return currStep+1; 
                if(setTar.contains(strBack.toString())) return currStep+1;  
                if(!set.contains(strFront.toString()) && !visited.contains(strFront.toString())){
                    
                    q.offer( new Pair(strFront.toString() , currStep+1));
                    visited.add(strFront.toString());
                }
                if(!set.contains(strBack.toString()) && !visited.contains(strBack.toString())){
                    q.offer( new Pair(strBack.toString() , currStep+1));
                    visited.add(strBack.toString());
                }
            }
        }
        return -1; 
    }
}