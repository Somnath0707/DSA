class TopVotedCandidate {
    // votes -> time -> person 
    TreeMap<Integer,TreeMap<Integer,Integer>> finalMap; 
    TreeMap<Integer,Integer> ans = new TreeMap<>(); 
    public TopVotedCandidate(int[] persons, int[] times) {

        // total votes per person 
        Map<Integer,Integer> personToVote = new HashMap<>(); 

        finalMap = new TreeMap<>(); 

        // latest time vote for each person 
        Map<Integer,Integer> personToTime = new HashMap<>(); 
        int n = persons.length; 

        for(int i = 0 ; i < n ; i++){
            int person = persons[i]; 
            int time = times[i]; 

            if(personToVote.containsKey(person)){
                int prevVote = personToVote.get(person);
                int prevTime = personToTime.get(person);

                finalMap.get(prevVote).remove(prevTime);// remove occ at that time 
                // if all the occ in that vote is removed remove that vote 
                if(finalMap.get(prevVote).isEmpty()){
                    finalMap.remove(prevVote);
                }
            }   

            personToVote.put(person , personToVote.getOrDefault(person , 0)+1);
            personToTime.put(person, time); 

            int currVote = personToVote.get(person);
            finalMap.putIfAbsent(currVote , new TreeMap<>());

            finalMap.get(currVote).put(time , person);

            int mostVote = finalMap.lastKey(); 
            int lastTime = finalMap.get(mostVote).lastKey(); 
            int lastPerson = finalMap.get(mostVote).get(lastTime); 

            ans.put(time , lastPerson);
        }
        


    }
    
    public int q(int t) {
        int key = ans.floorKey(t);
        return ans.get(key);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */