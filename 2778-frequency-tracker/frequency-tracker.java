class FrequencyTracker {
    Map<Integer , Integer> map ; 
    Map<Integer , Integer> freqCount ; 

    public FrequencyTracker() {
        map = new HashMap<>();
        freqCount = new HashMap<>(); // ✅ fix
    }
    
    public void add(int number) {
        int oldFreq = map.getOrDefault(number , 0);
        int newFreq = oldFreq + 1 ; 

        map.put(number , newFreq);

        // increase new freq
        freqCount.put(newFreq , freqCount.getOrDefault(newFreq , 0) + 1);

        // decrease old freq
        if(oldFreq > 0){
            freqCount.put(oldFreq , freqCount.get(oldFreq) - 1);
            if(freqCount.get(oldFreq) == 0) freqCount.remove(oldFreq);
        }
    }
    
    public void deleteOne(int number) {
        if(!map.containsKey(number)) return ; 

        int oldFreq = map.get(number); 
        int newFreq = oldFreq - 1 ; 

        // decrease old freq
        freqCount.put(oldFreq , freqCount.get(oldFreq) - 1);
        if(freqCount.get(oldFreq) == 0) freqCount.remove(oldFreq);

        if(newFreq == 0){
            map.remove(number);
        } else {
            map.put(number , newFreq); // ✅ fix
            freqCount.put(newFreq , freqCount.getOrDefault(newFreq , 0 ) + 1 );
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return freqCount.getOrDefault(frequency, 0) > 0; // ✅ fix
    }
}