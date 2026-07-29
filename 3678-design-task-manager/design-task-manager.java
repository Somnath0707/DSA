class TaskManager {
// If i dont solve this I am gay asf 
// map task id and user id 
// map task id and p id 
// Treemap p id to task

// so whenver update in pq go task id see which pq is it then take tha p id remove that task from there and put the new task 

// but in int the Tree map pq id  we need to have like pid + pq of tasklist we get the top task but update will be pain so we need tree map of treeset as the task id is at least unique ; 

    Map<Integer, Integer> taskToUser = new HashMap<>(); 
    Map<Integer ,Integer> taskToPriority = new HashMap<>(); 
    TreeMap<Integer,TreeSet<Integer>> priorityToTask =  new TreeMap<>(); 

    public TaskManager(List<List<Integer>> tasks) {
        int n = tasks.size(); 
        for(int i = 0 ; i < n ; i++){
            List<Integer> list = tasks.get(i); 
            int userId = list.get(0); 
            int taskId = list.get(1); 
            int priority = list.get(2); 
            taskToUser.put(taskId , userId); 
            taskToPriority.put(taskId , priority); 
            priorityToTask.putIfAbsent(priority , new TreeSet<>());
            priorityToTask.get(priority).add(taskId);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskToUser.put(taskId , userId); 
        taskToPriority.put(taskId , priority);
        priorityToTask.putIfAbsent(priority , new TreeSet<>());
        priorityToTask.get(priority).add(taskId);
    }
    
    public void edit(int taskId, int priority) {
        // first remove the taskId from the previous priority
        int old = taskToPriority.get(taskId); 
        priorityToTask.get(old).remove(taskId); 
        if(priorityToTask.get(old).isEmpty()){
            priorityToTask.remove(old); 
        }
        taskToPriority.put(taskId , priority);
        priorityToTask.putIfAbsent(priority , new TreeSet<>());
        priorityToTask.get(priority).add(taskId);

    }
    
    public void rmv(int taskId) {
        // first remove from the priority 
        int old = taskToPriority.get(taskId); 
        priorityToTask.get(old).remove(taskId); 
        if(priorityToTask.get(old).isEmpty()){
            priorityToTask.remove(old); 
        }
        taskToUser.remove(taskId); 
        taskToPriority.remove(taskId);


    }
    
    public int execTop() {
        if(priorityToTask.isEmpty()) return -1;
        int key = priorityToTask.lastKey();
        int task = priorityToTask.get(key).last();
        priorityToTask.get(key).remove(task);
        if(priorityToTask.get(key).isEmpty()){
            priorityToTask.remove(key); 
        }
        int ans = taskToUser.get(task);
        taskToPriority.remove(task); 
        taskToUser.remove(task);
        return ans;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */